/*
 * This program was designed for an arduino Uno, or any similar device that can communicate over 
 * serial USB.
 * ---------------------------------------------------------
 * This program is designed to have the arduino itself run custom code, so do not expect
 * that you can run this on any random arduino. The code required to get the arduino to work
 * can be found as a .ino file recognizable by the arduino IDE, within the zip package of this
 * program.
 */
package frontend_ViewController;

import com.fazecast.jSerialComm.SerialPort;

/**
 * This class is meant to be called in order to create a dialouge window, which
 * has several text boxes to get info from the user, like the size of the LED
 * strip, and if it is standard RGB or has a extra led, like the RBGW strips.
 * Should also detect if it cannot properly format the data entered, and ask for
 * it again, with the incorrect text boxes being cleared/highlighted.
 *
 *
 * @author kell-gigabyte
 */
public class InitPopup extends MainViewDisplayFX {
    public InitPopup() {

    }

    public void run() {
        createStage();
    }


    private void setLogFolder(String s) {
    }

    private void changePort(SerialPort port) {
    }

    private void createStage() {         // creates the GUI for the popup
    }

    /**
     * Ensures the user enters certain data before they can continue
     */
    private void checkData() {    // makes sure the data entered is formattable
    }

    /*
    checks if the fields have proper data, to have to a folder for future settings.
     */
    private boolean checkIfSaveable() {
      return false;
    }

    protected Settings SaveSettings() {
        return null;
    }

}
