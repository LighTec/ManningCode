/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinocommstester;

import arduinocomms2.Arduino;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class ArduinoCommsTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int pixels = 64;
        Scanner kbin = new Scanner(System.in);
        SerialPort[] commPorts = SerialPort.getCommPorts();
        SerialPort commPort = commPorts[0];
        for (int i = 0; i < commPorts.length; i++) {

            System.out.println("\n\n" + commPorts[i].getSystemPortName());
            System.out.println(commPorts[i].getBaudRate());
        }
        
        
        
       

        //SerialPort commTest = SerialPort.getCommPort(commPort.getSystemPortName());
        //boolean b = commTest.openPort();
        //System.out.println("\n\t" + b + "\n");
        //System.out.println(commPort.getSystemPortName());
        //System.out.println(commPort.getDescriptivePortName());
        Arduino arduino = new Arduino(commPort.getSystemPortName(), 9600); //enter the port name here, and ensure that Arduino is connected, otherwise exception will be thrown.
        arduino.openConnection();
       
 
       // System.out.println("Press any key to make the communism come alive");
       //String s = kbin.next();
      
       
       
        /*
        while(true){
            int i[] = new int[4];
            System.out.println("Please enter delay number 0-255.");
            String s = kbin.next();
            i[0] = Integer.parseInt(s);
            System.out.println("Val delay: " + i[0]);
            System.out.println("Please enter red number 0-255.");
            s = kbin.next();
            i[1] = Integer.parseInt(s);
            System.out.println("Val red: " + i[1]);
            System.out.println("Please enter green number 0-255.");
            s = kbin.next();
            i[2] = Integer.parseInt(s);
            System.out.println("Val green: " + i[2]);
            System.out.println("Please enter blue number 0-255.");
            s = kbin.next();
            i[3] = Integer.parseInt(s);
            System.out.println("Val blue: " + i[3]);
            
            for(int c = 0; c < i.length; c++){
                arduino.serialWrite((char)i[c]);
            }
        }
        
       */
       
        System.out.println("red");
        for(int i = 0; i < 256; i = i + 10){
            byte[] b = new byte[4];
            //System.out.println(i);
            b[0] = (byte)0;     //delay
            b[1] = (byte)i; //red
            b[2] = (byte)0;     //green
            b[3] = (byte)0;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(5);
        
            
        }
        System.out.println("red + green");
         for(int i = 0; i < 256; i = i + 10){
            byte[] b = new byte[4];
            //System.out.println(i);
            b[0] = (byte)0;     //delay
            b[1] = (byte)i; //red
            b[2] = (byte)i;     //green
            b[3] = (byte)0;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(5);
        }
         System.out.println("red + green + blue");
          for(int i = 0; i < 256; i = i + 10){
            byte[] b = new byte[4];
            //System.out.println(i);
            b[0] = (byte)0;     //delay
            b[1] = (byte)i; //red
            b[2] = (byte)i;     //green
            b[3] = (byte)i;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(5);
        }
          System.out.println("red + green");
           for(int i = 0; i < 256; i = i + 10){
            byte[] b = new byte[4];
            //System.out.println(i);
            b[0] = (byte)0;     //delay
            b[1] = (byte)i; //red
            b[2] = (byte)i;     //green
            b[3] = (byte)0;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(5);
        }
           System.out.println("red + blue");
         for(int i = 0; i < 256; i = i + 10){
            byte[] b = new byte[4];
            //System.out.println(i);
            b[0] = (byte)0;     //delay
            b[1] = (byte)i; //red
            b[2] = (byte)0;     //green
            b[3] = (byte)i;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(5);
        }
         System.out.println("green + blue");
        for(int i = 0; i < 256; i = i + 10){
            byte[] b = new byte[4];
            ////System.out.println(i);
            b[0] = (byte)0;     //delay
            b[1] = (byte)0; //red
            b[2] = (byte)i;     //green
            b[3] = (byte)i;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(5);
        }
        System.out.println("none");
            byte[] b = new byte[4];
            b[0] = (byte)0;     //delay
            b[1] = (byte)0; //red
            b[2] = (byte)0;     //green
            b[3] = (byte)0;     //blue
            arduino.byteArrayWrite(b);
            //Thread.sleep(200);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
/*
        while (true) { //uses bytes
        
              int m;
            byte[] b = new byte[320];
                m = 0;
                
                for (Short i = 0; i < pixels; i++) {
            //System.out.println("pixel " + i);

                b[m] = (byte) ((i >> 8) & 0xff);
                m++;
                b[m] = (byte) (i & 0xff);
                m++;
                
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
                
            for (Short i = 0; i < pixels; i++) {
            //System.out.println("pixel " + i);

                b[m] = (byte) ((i >> 8) & 0xff);
                m++;
                b[m] = (byte) (i & 0xff);
                m++;
                
                b[m] = (byte)55;
                m++;
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
                
            for (Short i = 0; i < pixels; i++) {
              //System.out.println("pixel " + i);

                b[m] = (byte) ((i >> 8) & 0xff);
                m++;
                b[m] = (byte) (i & 0xff);
                m++;
                
                b[m] = (byte)0;
                m++;
                b[m] = (byte)55;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
            for (Short i = 0; i < pixels; i++) {
               //System.out.println("pixel " + i);

                b[m] = (byte) ((i >> 8) & 0xff);
                m++;
                b[m] = (byte) (i & 0xff);
                m++;
                
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
                b[m] = (byte)55;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
             
            for (Short i = 0; i < pixels; i++) {
               //System.out.println("pixel " + i);

                b[m] = (byte) ((i >> 8) & 0xff);
                m++;
                b[m] = (byte) (i & 0xff);
                m++;
                
                b[m] = (byte)55;
                m++;
                b[m] = (byte)55;
                m++;
                b[m] = (byte)55;
                m++;
            }
            arduino.byteArrayWrite(b); 
            
        }
        */
        /*
         int m;
            byte[] b = new byte[192];
                m = 0;
                
            for (Short i = 0; i < pixels; i++) {
               //System.out.println("pixel " + i);
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
                
            for (Short i = 0; i < pixels; i++) {
               //System.out.println("pixel " + i);
                b[m] = (byte)55;
                m++;
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
            for (Short i = 0; i < pixels; i++) {
               //System.out.println("pixel " + i);
                b[m] = (byte)0;
                m++;
                b[m] = (byte)55;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
             m = 0;
             
            for (Short i = 0; i < pixels; i++) {
               //System.out.println("pixel " + i);
                b[m] = (byte)0;
                m++;
                b[m] = (byte)0;
                m++;
                b[m] = (byte)255;
                m++;
            }
            arduino.byteArrayWrite(b);
        */
        /*
        int m;
            byte[] b = new byte[160];
            for(Short a = 0; a < 2; a++){
                m = 0;
            for (Short i = (short)(a * 32); i < 32 * (a + 1); i++) {
               //System.out.println("pixel " + i);

                b[m] = (byte) ((i >> 8) & 0xff);
                m++;
                b[m] = (byte) (i & 0xff);
                m++;
                
                b[m] = (byte)0;
                m++;
                b[m] = (byte)127;
                m++;
                b[m] = (byte)0;
                m++;
            }
            arduino.byteArrayWrite(b);
            System.out.println("done inner loop " + (a + 1));
        }
            System.out.println("done all.");
*/
        /*
        while (true) {  //uses strings

            String[] output = new String[pixels];

            for (int i = 0; i < pixels; i++) {
                String nothing = "AAAAAA";
                String fin;
                String pixel = intToArduinoHex(i);
                if (i < 16) {
                    fin = "AA" + pixel + nothing;
                } else {
                    fin = "A" + pixel + nothing;
                }
                System.out.println(pixel + " is getting converted to nothing, " + fin);

                output[i] = fin;
            }
            arduino.serialWrite(output);
            s = kbin.next();

            for (int i = 0; i < pixels; i++) {
                String red = "PPAAAA";
                String fin;
                String pixel = intToArduinoHex(i);
                if (i < 16) {
                    fin = "AA" + pixel + red;
                } else {
                    fin = "A" + pixel + red;
                }
                System.out.println(pixel + " is getting converted to communism, " + fin);

                output[i] = fin;
            }
            arduino.serialWrite(output);
            s = kbin.next();

            for (int i = 0; i < pixels; i++) {
                String green = "AAPPAA";
                String fin;
                String pixel = intToArduinoHex(i);
                if (i < 16) {
                    fin = "AA" + pixel + green;
                } else {
                    fin = "A" + pixel + green;
                }
                System.out.println(pixel + " is getting converted to ecoterrorism, " + fin);

                output[i] = fin;
            }
            arduino.serialWrite(output);
            s = kbin.next();

            for (int i = 0; i < pixels; i++) {
                String blue = "AAAAPP";
                String fin;
                String pixel = intToArduinoHex(i);
                if (i < 16) {
                    fin = "AA" + pixel + blue;
                } else {
                    fin = "A" + pixel + blue;
                }
                System.out.println(pixel + " is getting converted to capitalism, " + fin);

                output[i] = fin;
            }
            arduino.serialWrite(output);
            s = kbin.next();

        }
         */
    }

    /**
     * Instead of 0-f, like regular hex, it's A-P.
     *
     * @param i
     * @return
     */
    public static String intToArduinoHex(int i) {
        String s = "";
        do {
            char c = (char) ((i % 16) + 65);
            //System.out.println(c);
            s += c;
            i /= 16;
        } while (i != 0);
        return new StringBuilder(s).reverse().toString();

    }

}

/* Manual Entry, old version
        System.out.println("Enter pixel FFF, red FF, green FF, blue FF then a z, like this: FFFAABBCCz");
        String input = kbin.nextLine();
        while (true) {
            System.out.println(input);
            arduino.serialWrite(input);
           // System.out.println(arduino.serialRead());
            input = kbin.nextLine();
        }
        kbin.close();
        arduino.closeConnection();
 */

 /*      //for the old hex formatting
    String[] output = new String[pixels];
    
        for (int i = 0; i < pixels; i++) {
            String red = "000000z";
           String fin;
            String pixel = Integer.toHexString(i);
             if(i < 16){
                fin = "00" + pixel + red;
            }else{
               fin = "0" + pixel + red;
            }
            System.out.println(pixel + " is getting converted to nothing, " + fin);
            
            output[i] = fin;
        }
        arduino.serialWrite(output);
        s = kbin.next();
        Thread.sleep(50);
        
        for (int i = 0; i < pixels; i++) {
            String red = "FF0000z";
           String fin;
            String pixel = Integer.toHexString(i);
             if(i < 16){
                fin = "00" + pixel + red;
            }else{
               fin = "0" + pixel + red;
            }
            System.out.println(pixel + " is getting converted to communism, " + fin);
            
           output[i] = fin;
        }
        arduino.serialWrite(output);
        s = kbin.next();
        Thread.sleep(50);
        
        for (int i = 0; i < pixels; i++) {
            String red = "00FF00z";
           String fin;
            String pixel = Integer.toHexString(i);
             if(i < 16){
                fin = "00" + pixel + red;
            }else{
               fin = "0" + pixel + red;
            }
            System.out.println(pixel + " is getting converted to ecoterrorism, " + fin);
            
            output[i] = fin;
        }
        arduino.serialWrite(output);
        s = kbin.next();
        Thread.sleep(50);
        
        for (int i = 0; i < pixels; i++) {
            String red = "0000FFz";
           String fin;
            String pixel = Integer.toHexString(i);
             if(i < 16){
                fin = "00" + pixel + red;
            }else{
               fin = "0" + pixel + red;
            }
            System.out.println(pixel + " is getting converted to capitalism, " + fin);
            
            output[i] = fin;
        }
        arduino.serialWrite(output);
        s = kbin.next();
        Thread.sleep(50);
 */
