/*
 * Created By Kell Larson for the Computer Science AP program during school year 2016/2017. Please ask before copying code.
 */
package baseclass;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Kell
 */
public class BaseClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(3); //may need to change value
        fmt.setMaximumFractionDigits(3); //may need to change value
        Scanner sf = new Scanner(new File(""));
        int maxIndx = -1; //-1 so when we increment below, the first index is 0
        String text[] = new String[1000]; //To be safe, declare more than we need
        while (sf.hasNext()) {
            maxIndx++;
        }
        text[maxIndx] = sf.nextLine();
        //System.out.println(text[maxIndx]); //Remove rem for testing                     
        //maxIndx is now the highest index of text[]. Equals -1 if no text lines
        sf.close(); //We opened a file above, so close it when finished.
        //System.exit(0);  //Use this for testing… to temporarily end the program here
        for (int j = 0; j <= maxIndx; j++) {       //Typically, only one of the following two will be used.
            //StringTokenizer st = new StringTokenizer( text[j] );
            //Scanner sc = new Scanner(text[j]);
            //…code specific to the task…
            //System.out.println(text[j]);  //Remove rem for testing
        }
    }

}
