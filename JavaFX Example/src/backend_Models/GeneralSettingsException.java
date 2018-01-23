/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
*/
package backend_Models;

/**
 *
 * @author kell-gigabyte
 */
public class GeneralSettingsException extends Exception {

    /**
     * Creates a new instance of <code>GeneralSettingsException</code> without
     * detail message.
     */
    public GeneralSettingsException() {
    }

    /**
     * Constructs an instance of <code>GeneralSettingsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GeneralSettingsException(String msg) {
        super(msg);
    }
}
