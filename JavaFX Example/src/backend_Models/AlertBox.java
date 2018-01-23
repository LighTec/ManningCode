/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
*/
package backend_Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AlertBox {

    JFrame alertWindow;

    /*
    A simple popup window, Used to tell user error messages.
    
    Called like this:
    
    
    AlertBox alert = new AlertBox(new Dimesion(width, height), title, message);
    alert.dislay();
    
    width and height are integers, which represent width and height in pixels, title is the 
    text in the top bar, and message is what is displayed within the window. 
    
    This is actually ripped out of a library, author is in the link below:
    https://github.com/HirdayGupta/Java-Arduino-Communication-Library
    */
    public AlertBox(Dimension obj, String title, String message) {
        alertWindow = new JFrame();
        alertWindow.setTitle(title);
        alertWindow.setSize(obj);
        alertWindow.setPreferredSize(obj);
        alertWindow.setLayout(new BorderLayout());
        alertWindow.setLocationRelativeTo(null);
        JTextArea lblMessage = new JTextArea(message);
        lblMessage.setLineWrap(true);
        lblMessage.setEditable(false);
        lblMessage.setWrapStyleWord(true);
        lblMessage.setFont(new Font(lblMessage.getFont().getName(), Font.BOLD, 24));
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener((ActionEvent e) -> {
            alertWindow.setVisible(false);
            alertWindow.dispose();
        });
        alertWindow.add(btnOk, BorderLayout.SOUTH);
        alertWindow.add(lblMessage, BorderLayout.CENTER);
    }

    /*
    Must call this for the AlertBox to display
    */
    public void display() {
        alertWindow.setVisible(true);
    }
}
