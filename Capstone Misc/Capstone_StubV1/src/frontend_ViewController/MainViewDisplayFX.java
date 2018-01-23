/*
 * This program was designed for a arduino Uno, or any similar device that can communicate over 
 * serial USB.
 * ---------------------------------------------------------
 * This program is designed to have the arduino itself run custom code, so do not expect
 * that you can run this on any random arduino. The code required to get the arduino to work
 * can be found as a .ino file recognizable by the arduino IDE, within the zip package of this
 * program.
 */
package frontend_ViewController;

import backend_Models.GeneralSettingsException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Class for creation and display of the main GUI, Uses JavaFX.
 *
 * @author kell-gigabyte
 */
public class MainViewDisplayFX extends Application {

    public static void init(String[] args) {
        System.out.println("GUI Initializing");
        launch(args);

    }

    private ViewController MVControl;

    @Override
    public void start(Stage primaryStage) throws GeneralSettingsException {
        this.MVControl = new ViewController();
    }
}
