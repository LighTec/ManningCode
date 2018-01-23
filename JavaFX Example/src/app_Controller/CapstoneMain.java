/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
*/
package app_Controller;

import frontend_ViewController.MainViewDisplayFX;

/**
 *Nothing really within this class, just get the "look and feel" of the OS, then creates a javaFX
 * window. The res is handled within the javaFX background thread creation. Really just don't touch it.
 * 
 * 
 * @author Kell
 */
public class CapstoneMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
            System.err.println(ex);
        } catch (IllegalAccessException ex) {
            System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
            MainViewDisplayFX.init(args);
            Kaizen_85.newEvent("Main class successfully handled, handing off to JavaFX application.");
    }
    
}
