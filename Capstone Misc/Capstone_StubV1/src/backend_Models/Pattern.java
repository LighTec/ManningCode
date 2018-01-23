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
import java.awt.Color;

/**
 *
 * @author kell-gigabyte
 */
public abstract class Pattern {

    protected final Settings settings;
    protected static SerialComms serialcomms;
    
     protected int red;
    protected int green;
    protected int blue;
    protected int delay;
    protected int currentIndex;
    
    public Pattern(Settings set, SerialComms serial){
        this.settings = set;
        serialcomms = serial;
    }
    
     public void setColor(Color c) {
        this.red = c.getRed();
        this.green = c.getGreen();
        this.blue = c.getBlue();
    }

    public boolean setColor(int r, int g, int b) {
        if(r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) // if any color values exceed 255, or less than 0
            return false;
        this.red = r;
        this.green = g;
        this.blue = b;
        return true;
    }

    public void setDelay(int i) {
        this.delay = i;
    }
    
    public boolean setColor(Color c, int index){
        return false;
    }

    public boolean setColor(int r, int g, int b, int index){
        
        return false;
    }
    
    public boolean setColor(Color c, int x, int y){
        return false;
    }

    public boolean setColor(int r, int g, int b, int x, int y){
        return false;
    }

    public void startPattern(){
         throw new UnsupportedOperationException("startPattern method has not been overridden!");
    }

    public void startTestPattern(/*DemoDisplay d*/){
        
    }           // will implement a demoDisplay for the GUI later hopefully. It's a stretch goal.
}
