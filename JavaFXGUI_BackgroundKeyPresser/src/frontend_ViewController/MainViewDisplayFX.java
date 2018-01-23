/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
 */
package frontend_ViewController;

import app_Controller.Kaizen_85;
import backend_Models.GeneralSettingsException;
import static java.awt.SystemColor.info;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class MainViewDisplayFX extends Application {

    public static void init(String[] args) {
        //System.out.println("GUI Initializing");
        launch(args);

    }

    private ViewController MVControl;

    @Override
    public void start(Stage primaryStage) throws GeneralSettingsException {
        primaryStage.setTitle("JavaFX for the win!");
        primaryStage.getIcons().add(new Image("/JavaFX/icon256.png")); // The application icon, you
        primaryStage.getIcons().add(new Image("/JavaFX/icon128.png")); // need multiple pixel sizes
        primaryStage.getIcons().add(new Image("/JavaFX/icon64.png"));  // in order to properly support
        primaryStage.getIcons().add(new Image("/JavaFX/icon32.png"));  //most OS. Recommended:
        primaryStage.getIcons().add(new Image("/JavaFX/icon16.png"));  // 16px, 32px, 64px, 128px. Optional 256px.

        BorderPane root = new BorderPane(); // The root pane, only has 5 or so nodes to connect to, so is
        //usually used to put panes into.

        HBox hbox = addHBox();  // the 'H' Characters
        root.setTop(hbox);
        root.setRight(addFlowPane());   // the 'F' Characters

        root.setCenter(addAnchorPane(addGridPane())); // Both the 'A' and 'G' characters

        Scene scene = new Scene(root);

        InitPopup InfoGetter = new InitPopup(); // The initialization window starts before the main window.
        InfoGetter.run();

        Settings settings = InfoGetter.SaveSettings();  // Saves the settings in the Settings object.

        this.MVControl = new ViewController(settings);  // Pass the settings on.

        primaryStage.setScene(scene);   // Sets the scene to the thing we have added all these Panes to.
        Kaizen_85.newEvent("Init complete, showing main stage.");

        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            if (GlobalScreen.isNativeHookRegistered()) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException ex) {
                    Logger.getLogger(MainViewDisplayFX.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        });

        primaryStage.show();    // Shows the GUI.
    }

    private HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #FF4500;");

        Text epicTextForSomeReason = new Text("An example of JavaFX application GUI.");
        epicTextForSomeReason.setFont(new Font(25)); // set font size to 25, default font name and weight.

        /*
        Button buttonCurrent = new Button("Set LED");
        buttonCurrent.setPrefSize(100, 20);

        Button buttonProjected = new Button("Set All");
        buttonProjected.setPrefSize(100, 20);
         */
        hbox.getChildren().addAll(epicTextForSomeReason);

        return hbox;
    }

    private TextField delayField = new TextField("0");

    private Slider delaySlider = new Slider();

    private GridPane addGridPane() {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_RIGHT);
        //grid.setHgap(25);
        //grid.setVgap(25);
        grid.setPadding(new Insets(0, 15, 50, 15));

        //scenetitle.setFill(Color.SALMON);
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        Text delayTitle = new Text("Delay: ");

        this.delaySlider.setMin(0);

        this.delaySlider.setMax(1000);

        this.delayField.setMaxWidth(60); // in pixel measurements

        this.delaySlider.valueProperty().addListener((ov, t, t1) -> {   // Runs a method when values on the slider are changed.
            updateValuesText();
        });

        this.delayField.textProperty().addListener((ov, t, t1) -> {     // Runs a method when values on the Text box are changed.
            updateValuesSlider();
        });

        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.add(delayTitle, 0, 1);
        grid.add(this.delaySlider, 1, 1);
        grid.add(this.delayField, 2, 1);

        //grid.setGridLinesVisible(true);   // Use to see how JavaFX is decided to make the grid. Great for debugging.
        return grid;
    }

    private FlowPane addFlowPane() {

        FlowPane flow = new FlowPane();
        flow.setStyle("-fx-background-color: #B0C4DE;");
        flow.setPadding(new Insets(5, 10, 5, 10));
        flow.setVgap(4);
        flow.setHgap(4);
        flow.setPrefWrapLength(170); // preferred width allows for two columns

        Button TheaterChaseRainbowBtn = new Button("Random");
        TheaterChaseRainbowBtn.setOnAction(this::Random);

        Button pressMe = new Button("Press me");
        pressMe.setOnAction(this::Sudoku);

        Button HelloBtn = new Button("Say 'Hello World'");
        HelloBtn.setOnAction(this::HelloWorld);
        flow.getChildren().addAll(TheaterChaseRainbowBtn, HelloBtn, pressMe);

        return flow;
    }

    private AnchorPane addAnchorPane(GridPane grid) {

        AnchorPane anchorpane = new AnchorPane();

        //anchorpane.setStyle("-fx-background-color: #FFD700");
        Button StartBtn = new Button("Start");
        StartBtn.setOnAction(this::startPattern);

        Button SetColorBtn = new Button("Set Color");
        SetColorBtn.setOnAction(this::ColorSet);

        Button setDelayBtn = new Button("Set Delay");
        setDelayBtn.setOnAction(this::DelaySet);

        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
        hb.getChildren().addAll(StartBtn, SetColorBtn, setDelayBtn);

        anchorpane.getChildren().addAll(grid, hb);
        // Anchor buttons to bottom right, anchor grid to top
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);
        anchorpane.setStyle("-fx-background-color:#0000FF;"); // an example of using RGB colors to set background color.
        // You can use CSS instead of these commands, but this is easier to use for simple color changes.

        return anchorpane;
    }

    private void HelloWorld(ActionEvent event) {
        this.MVControl.HelloWorld();
    }

    private void Random(ActionEvent event) {
        Kaizen_85.newEvent(" pattern set.");
        this.MVControl.random();
    }

    private void startPattern(ActionEvent event) {
        System.out.println("Start pattern called");
    }

    private void ColorSet(ActionEvent event) {
        System.out.println("Color set called.");
    }

    private void DelaySet(ActionEvent event) {
        System.out.println("Delay set called.");
    }

    private boolean areYouSure = false;

    private void Sudoku(ActionEvent event) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

// Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);

        GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
            public void nativeKeyPressed(NativeKeyEvent e) {
                System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
            }

            public void nativeKeyReleased(NativeKeyEvent e) {
                //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
            }

            public void nativeKeyTyped(NativeKeyEvent e) {
                //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
            }
        });
    }

    private void updateValuesSlider() { // updates sliders from text fields
        int delay;

        if (this.delayField.getText().equals("")) {
            delay = 0;
        } else {
            delay = Integer.parseInt(this.delayField.getText());
        }

        if (delay > 2000) {
            delay = 2000;
        } else if (delay < 0) {
            delay = 0;
        }
        this.delaySlider.setValue(delay);
    }

    private void updateValuesText() { // updates text fields from sliders
        //Kaizen_85.newEvent("Values dupated from sliders to text fields.");
        int delay = (int) Math.round(this.delaySlider.getValue());
        if (delay > 2000) {
            delay = 2000;
        } else if (delay < 0) {
            delay = 0;
        }
        String d = "" + delay;
        this.delayField.setText(d);
    }

}
