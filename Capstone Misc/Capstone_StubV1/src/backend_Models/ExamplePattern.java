/*
 * This program was designed for a arduino Uno, or any similar device that can communicate over 
 * serial USB.
 * ---------------------------------------------------------
 * This program is designed to have the arduino itself run custom code, so do not expect
 * that you can run this on any random arduino. The code required to get the arduino to work
 * can be found as a .ino file recognizable by the arduino IDE, within the zip package of this
 * program.
 */
package backend_Models;

import frontend_ViewController.Settings;

/**
 *
 * @author kell-gigabyte
 */
public class ExamplePattern extends Pattern {

    public ExamplePattern(Settings set, SerialComms serial) {
        super(set, serial);
    }

    /**
     * Starts the pattern generation process, and begins sending bytes to the
     * arduino for the LED strip to run.
     */
    @Override
    public void startPattern() {
    }

}
