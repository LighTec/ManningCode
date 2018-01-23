/*
This Program is meant as an example for Using JavaFX, with an initialization popup pane, and MVC Architecture.
It uses multiple
*/
package app_Controller;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author kell-gigabyte
 */
public class Kaizen_85 {
    
    private static final ArrayList Kaizen85 = new ArrayList();
    
    private static String pathToLog;
    
    /**
     *      Sets the event for Kaizen-85, the name for the logger.
     * @param logPath
     */
    public static void setLogPath(String logPath){
        pathToLog = logPath;
    }
    
    /**
     *  Call this whenever you are accessing a method or doing something new, this acts as a simple
     * logger. Kaizen-85 will record all event given to it.
     * @param newEvent 
     */
    public static void newEvent(String newEvent){
        System.out.println("Event has been incremented. Current event is [" + Kaizen85.size() + "]");
        Kaizen85.add(newEvent);
    }
    
    /**
     * Call when program is failing, Kaizen-85 Will print it out into the submitted folder, to help debug the program.
     */
    public static void panic(){
        try{
           //System.out.println(pathToLog);
            FileWriter fw = new FileWriter(pathToLog + "/Kaizen85Log.txt");
            PrintWriter printer = new PrintWriter(fw);
            ListIterator iter = Kaizen85.listIterator();
            while(iter.hasNext()){
                String s = (String) iter.next();
                printer.println(s);
            }
            printer.close();
            fw.close();
        }catch(FileNotFoundException e){
            System.err.println("Inputted file not found while trying to panic write logs,   " + e);
        }catch(IOException e){
            System.err.println("General IO exception while panic log writing   " + e);
            
        }
    }
            
    
}
