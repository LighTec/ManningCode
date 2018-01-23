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

import app_Controller.Kaizen_85;
import backend_Models.AlertBox;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author kell-gigabyte
 */
public class ViewController {

    private final Settings settings;

    public ViewController(Settings s) {
        Kaizen_85.newEvent("ViewController Created");
        this.settings = s;
    }

    protected void HelloWorld() {
        Kaizen_85.newEvent("Hello World button pressed, HELLO WORLD.");
        Kaizen_85.panic();
    }

    public void random() {
        try {

            throw new NullPointerException("Why is life so cruel?");
            //usually some scanner or other thing. A throw is used here as an example of the AlertBox.

        } catch (NullPointerException e) {
            AlertBox alert = new AlertBox(new Dimension(800, 200), "Example Error Title", "Example error message. " + e);
            alert.display();
        }
    }
}
