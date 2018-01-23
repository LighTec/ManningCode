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

import backend_Models.Pattern;

/**
 *
 * @author kell-gigabyte
 */
public class ViewController{

    private static Pattern pattern;
    //private static SerialComms serialComms;
    
    public ViewController() {
        //this.HelloBtn.setOnAction((event) -> this.HelloWorld(event));
        // this.CalcFibBtn.setOnAction(new CalcFib());
       // System.out.println("View controller object created");
    }
    /*
     *
     * ModelsAndViewsController needs to have an instance variable to reference
     * the backend's models because the frontend's ModelsAndViewsController is
     * responsible for asking the backend to modify its data.
     *
     * Since the backend models is initially set up by an instance of the
     * BackendModelSetup class, we just need this one instance variable here:
     */
    //public BackendModelSetup theBackendModel;
    /*
    public void ModelsAndViewsController(BackendModelSetup aBackend) {
        this.theBackendModel = aBackend;
    }
     */
    
    private boolean isStarted = false;
    protected boolean startStop(){
        if(isStarted){
            
        }else{
            
        }
        isStarted = !isStarted;
        return this.isStarted;
    }
    
    public void choosePattern(Pattern pat){
        pattern = pat;
    }
    
    public void startPattern(){
        pattern.startPattern();
    }
}
