/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
*/
package frontend_ViewController;

import app_Controller.Kaizen_85;

/**
 *  Acts as an intermediary between the initialization dialog, and the backend objects.
 *  Easier than sending multitudes of values every time an object constructs.
 * 
 * @author kell-gigabyte
 */
public class Settings {
    
    
    private boolean isMatrix;
    private int stripLength;
    private int stripWidth;
    
    private boolean debugMode = false;
    
    
    public Settings(boolean isMatrix, String patternFolder, int stripLength, int stripWidth){
        this.isMatrix = isMatrix;
        this.stripLength = stripLength;
        this.stripWidth = stripWidth;
        Kaizen_85.newEvent("Settings initialized normally.");
    }
    
    public Settings(){
        this.debugMode = true;
        Kaizen_85.newEvent("Settings initialized uncorrectly, Debug mode enabled.");
    }
    
    public boolean getIsMatrix(){
         return this.isMatrix;
    }
           
    public int getStripLength(){
        return this.stripLength;
    }
    
    public int getStripWidth(){
        return this.stripWidth;
    }
    
    public boolean getDebugMode(){
        return this.debugMode;
    }
}