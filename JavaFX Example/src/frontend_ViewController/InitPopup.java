/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
*/
package frontend_ViewController;

import app_Controller.Kaizen_85;
import backend_Models.AlertBox;
import java.io.File;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 * This class is meant to be called in order to create a dialouge window, which
 * has several text boxes to get info from the user, like the size of the LED
 * strip, and if it is standard RGB or has a extra led, like the RBGW strips.
 * Should also detect if it cannot properly format the data entered, and ask for
 * it again, with the incorrect text boxes being cleared/highlighted.
 *
 * An example of an initialization dialog window, this one gets values from the user, allows loading/saving
 * of those values, and disables the continue button until all values are in an acceptable range, 
 * e.g. if they write letters in the text box, it won't let them continue because you cannot parse letters.
 *
 * @author kell-gigabyte
 */
public class InitPopup {

    boolean isMatrix;

    boolean isComplete = false;

    String patternFolder = "";
    String logFolder = "";

    private int stripLength;
    private int stripWidth;
    private int pin;


    public InitPopup() {

    }

    public void run() {
        createStage();
    }

    protected boolean isComplete() {
        return this.isComplete;
    }

    private void setLogFolder(String s) {
        this.logFolder = s;
    }

    private TextField LengthStrText = new TextField();
    private TextField WidthStrText = new TextField();
    private TextField PinStrText = new TextField();

    private Button SaveSettings = new Button("Save Settings");

    private boolean isDebug = false;

    private Node confirmButton;

    private void createStage() {         // creates the GUI for the popup
        Dialog dialog = new Dialog<>();
        dialog.setTitle("Hello!");
        dialog.setHeaderText("Hello WRLD!");

        ButtonType confirmButtonType = new ButtonType("Enter", ButtonData.APPLY);
        dialog.getDialogPane().getButtonTypes().addAll(confirmButtonType);
        dialog.getDialogPane().setStyle("-fx-background-color: #404040;");  // set color of window with RGB hex values.

        String StripStr = "In a Strip";
        String MatrixStr = "In a Matrix";
        String logFolderStr = "Log Folder";

        ToggleButton Strip = new ToggleButton(StripStr);
        ToggleGroup aStrip = new ToggleGroup();
        Strip.setToggleGroup(aStrip);

        ToggleButton DebugBtn = new ToggleButton("Debug mode");

        Button LogBtn = new Button(logFolderStr);
        Button LoadSettings = new Button("Load settings from file");

        this.SaveSettings.setDisable(true);

        LogBtn.setOnAction((ActionEvent event) -> {
            FileChooser saveChooser = new FileChooser();
            saveChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File selectedFolder = saveChooser.showSaveDialog(dialog.getOwner());
            if (selectedFolder == null) {
            } else {

                setLogFolder(selectedFolder.getAbsolutePath());
                System.out.println(selectedFolder.getAbsolutePath());
                checkData();
            }
        });

        /*
        Save folder syntax:
            [isMatrix],[stripLength],[StripWidth],[pin],[Pattern folder], [Log folder]
         */
        DebugBtn.setOnAction((ActionEvent event) -> {
            if (this.isDebug) {
                this.isDebug = false;
            } else {
                this.isDebug = true;
            }
            checkData();
        });

        SaveSettings.setOnAction((ActionEvent event) -> {
            String folder;
            String saveString;
            FileChooser saveChooser = new FileChooser();
            saveChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File selectedFolder = saveChooser.showSaveDialog(dialog.getOwner());
            if (selectedFolder == null) {
                AlertBox alert = new AlertBox(new Dimension(400, 100), "Folder Error", "Error selecting folder. Try again.");
                alert.display();
            } else {
                folder = selectedFolder.getAbsolutePath();
                FileWriter fw;
                try {
                    fw = new FileWriter(folder);
                    PrintWriter printer = new PrintWriter(fw);
                    if (this.isMatrix) {
                        printer.print("T,");
                    } else {
                        printer.print("F,");
                    }
                    printer.print(this.stripLength + ",");
                    if (this.isMatrix) {
                        printer.print(this.stripWidth + ",");
                    }
                    printer.print(this.pin + ",");
                    printer.print(this.logFolder);
                    printer.close();
                    fw.close();
                    AlertBox alert = new AlertBox(new Dimension(200, 100), "Success", "Success saving settings.");
                } catch (IOException ex) {
                    AlertBox alert = new AlertBox(new Dimension(400, 100), "Folder Error", "Error writing to folder. Try again.");
                }
            }
        });

        LoadSettings.setOnAction((ActionEvent event) -> {
            String folder;
            String loadString;
            FileChooser loadChooser = new FileChooser();
            loadChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File selectedFolder = loadChooser.showOpenDialog(dialog.getOwner());
            if (selectedFolder == null) {
                AlertBox alert = new AlertBox(new Dimension(400, 100), "Folder Error", "Error selecting folder. Try again.");
                alert.display();
            } else {
                folder = selectedFolder.getAbsolutePath();
                try {
                    Scanner file = new Scanner(new File(folder));
                    file.useDelimiter(",");
                    String temp;
                    temp = file.next();
                    if (temp.equals("F")) {
                        Strip.setText(StripStr);
                        this.isMatrix = false;
                    } else {
                        Strip.setText(MatrixStr);
                        this.isMatrix = true;
                    }
                    this.WidthStrText.setDisable(!isMatrix);
                    this.LengthStrText.setText("" + file.nextInt());
                    if (this.isMatrix) {
                        this.WidthStrText.setText("" + file.nextInt());
                    }
                    this.PinStrText.setText("" + file.nextInt());
                    this.logFolder = file.next();
                    file.close();
                    checkData();
                } catch (FileNotFoundException ex) {
                    AlertBox alert = new AlertBox(new Dimension(400, 100), "Folder Error", "Error finding folder. Try again.");
                    alert.display();
                }
            }
        });

        aStrip.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) -> {
            if (new_toggle == null) {
                Strip.setText(StripStr);
                isMatrix = false;
            } else {
                Strip.setText(MatrixStr);
                isMatrix = true;
            }
            this.WidthStrText.setDisable(!isMatrix);
        });

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: #FF9933;");
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        this.LengthStrText.setPromptText("Length");
        this.LengthStrText.setMaxWidth(90);

        this.WidthStrText.setPromptText("Width");
        this.WidthStrText.setMaxWidth(90);
        this.WidthStrText.setDisable(true);

        this.PinStrText.setPromptText("Pin #");
        this.PinStrText.setMaxWidth(90);

        grid.add(new Label("Example text 1 asdf"), 0, 0);
        grid.add(this.LengthStrText, 1, 0);
        grid.add(this.WidthStrText, 2, 0);
        grid.add(new Label("Example text 2 sdfg"), 0, 1);
        grid.add(Strip, 1, 1);
        grid.add(new Label("Example text 3 dfgh"), 0, 3);
        grid.add(this.PinStrText, 1, 3);
        grid.add(new Label("Please choose a folder for the logs:"), 0, 4);
        grid.add(LogBtn, 1, 4);
        grid.add(LoadSettings, 0, 5);
        grid.add(SaveSettings, 1, 5);
        grid.add(DebugBtn, 0, 6);
        grid.setGridLinesVisible(false);

        this.confirmButton = dialog.getDialogPane().lookupButton(confirmButtonType);
        confirmButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        LengthStrText.textProperty().addListener((observable, oldValue, newValue) -> {
            checkData();
        });
        this.WidthStrText.textProperty().addListener((observable, oldValue, newValue) -> {
            checkData();
        });
        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> LengthStrText.requestFocus());
        Kaizen_85.newEvent("Initialization window created, showing.");
        dialog.showAndWait();
    }

    /**
     * Ensures the user enters certain data before they can continue
     */
    private void checkData() {    // makes sure the data entered is formattable
        Kaizen_85.newEvent("Data check for init dialog, path folder is " + this.logFolder + " and the current LED text field entry is " + LengthStrText.getText());
        boolean intParsable = false;

        try {   // Using a try-catch to see if text is parseable into an integer.
            int i = Integer.parseInt(this.LengthStrText.getText());
            if (this.isMatrix) {
                i = Integer.parseInt(this.WidthStrText.getText());
            }
            i = Integer.parseInt(this.PinStrText.getText());
            intParsable = true;
        } catch (NumberFormatException e) {
            //System.err.println("Number entered on init panel is invalid, please try again.");
        }

        if (this.isDebug) {
            this.confirmButton.setDisable(false);
        } else if (intParsable) {
            this.stripLength = Integer.parseInt(this.LengthStrText.getText());
            this.stripWidth = Integer.parseInt(this.WidthStrText.getText());
            this.pin = Integer.parseInt(this.PinStrText.getText());
            this.confirmButton.setDisable(false);

        } else {
            this.confirmButton.setDisable(true);
        }

        this.SaveSettings.setDisable(!checkIfSaveable()); // disable the button if the method returns false, but it needs to be true to disable.
    }

    /*
    checks if the fields have proper data, to have to a folder for future settings.
     */
    private boolean checkIfSaveable() {
        Kaizen_85.newEvent("Data check for init dialog, path folder is " + this.logFolder + " and the current LED text field entry is " + LengthStrText.getText());
        boolean intParsable = false;

        try {
            int i = Integer.parseInt(this.LengthStrText.getText());
            if (this.isMatrix) {
                i = Integer.parseInt(this.WidthStrText.getText());
            }
            i = Integer.parseInt(this.PinStrText.getText());
            intParsable = true;
            this.stripLength = Integer.parseInt(this.LengthStrText.getText());
            if (this.isMatrix) {
                this.stripWidth = Integer.parseInt(this.WidthStrText.getText());
            }
            this.pin = Integer.parseInt(this.PinStrText.getText());
        } catch (NumberFormatException e) {
            //System.err.println("Number entered on init panel is invalid, please try again.");
        }

        return intParsable;
    }

    protected Settings SaveSettings() {
        Settings newSettings;
        if (this.isDebug) {
            newSettings = new Settings();
        } else {
            newSettings = new Settings(this.isMatrix, this.patternFolder, this.stripLength, this.stripWidth);
        }
        Kaizen_85.setLogPath(this.logFolder);
        return newSettings;
    }

}
