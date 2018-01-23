package backend_models;

import java.io.*;
import java.util.Scanner;

/**
 * A class to model the problem or situation your program solves
 * 
 * There should be no code here directly about painting graphics on the screen,
 * and no code here for directly handling user interaction.
 * 
 * All user interface related code must go in the frontend classes.
 * 
 * @author cheng
 */
public class PowListFile {

    private PowPerson[] powList;
    private int powCount;

    public PowListFile() {
        powList = new PowPerson[10000];
        powCount = 0;
    }

    public PowPerson[] toArray() {
        PowPerson[] unbufferedPowList = new PowPerson[powCount];
        for (int i = 0; i < powCount; i++) {
            unbufferedPowList[i] = powList[i];
        }

        return unbufferedPowList;
    }

    public void addPow(PowPerson pp) {
        if (powCount >= powList.length) {
            return;
        }

        powList[powCount] = pp;
        powCount++;
    }

    public PowPerson getPow(int powSerial) {
        for (int i = 0; i < powCount; i++) {
            PowPerson pp = powList[i];
            if (pp.getSerial() == powSerial) {
                return pp;
            }
        }
        return null;
    }
    
    public String getSaveString(){
        String saveStr = "";
        
        for (int i = 0; i < powCount; i++){
            saveStr = saveStr + powList[i].getSaveString();
            saveStr = saveStr + "\n";
        }
        
        return saveStr;
    }
    
    public void saveToFile(String pathToFile) throws IOException{
        FileWriter fw = new FileWriter(pathToFile);
        PrintWriter pw = new PrintWriter(fw);
        String saveStr = this.getSaveString();
        pw.print(saveStr);
        pw.close();
    }
    

    public void openFromFile(String pathToFile) throws IOException{
        File f = new File(pathToFile);
        Scanner sc = new Scanner(f);
        
        powList = new PowPerson[10000];
        powCount = 0;
        
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] fields = line.split(";");
            
            PowPerson pp = new PowPerson();
            pp.setName(fields[0]);
            pp.setRank(fields[1]);
            int serial = Integer.parseInt(fields[2]);
            pp.setSerial(serial);
            pp.setGender(fields[3]);
            // System.out.println(pp.getGender()); // for debugging
            
            this.addPow(pp);
        }
        
        // System.out.println(this.getSaveString()); // for debugging
    }

}
