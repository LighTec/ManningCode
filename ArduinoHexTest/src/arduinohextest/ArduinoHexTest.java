/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinohextest;

import arduinocomms2.Arduino;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class ArduinoHexTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        int i = 255;
        String s = intToArduinoHex(i);
        System.out.println("asf " + s + " -> " + Integer.toHexString(i));
        i = 127;
        s = intToArduinoHex(i);
        System.out.println("asf " + s + " -> " + Integer.toHexString(i));
        i = 500;
        s = intToArduinoHex(i);
        System.out.println("asf " + s + " -> " + Integer.toHexString(i));
        i = 10;
        s = intToArduinoHex(i);
        System.out.println("asf " + s + " -> " + Integer.toHexString(i));
        i = 0;
        s = intToArduinoHex(i);
        System.out.println("asf " + s + " -> " + Integer.toHexString(i));
         */

 /*
        for (int i = 0; i < 1001; i++) {
            System.out.println("Arduino hex:  " + intToArduinoHex(i) + " Regular hex format: " + Integer.toHexString(i));
        }
         */
        int pixels = 64;
        Scanner kbin = new Scanner(System.in);
        SerialPort[] commPorts = SerialPort.getCommPorts();
        SerialPort commPort = commPorts[0];
        for (int i = 0; i < commPorts.length; i++) {

            System.out.println("\n\n" + commPorts[i].getSystemPortName());
            System.out.println(commPorts[i].getBaudRate());
        }

        SerialPort commTest = SerialPort.getCommPort(commPort.getSystemPortName());

        //boolean b = commTest.openPort();
        //System.out.println("\n\t" + b + "\n");
        //System.out.println(commPort.getSystemPortName());
        //System.out.println(commPort.getDescriptivePortName());
        Arduino arduino = new Arduino(commPort.getSystemPortName(), 9600); //enter the port name here, and ensure that Arduino is connected, otherwise exception will be thrown.
        arduino.openConnection();

        String[] output = new String[pixels];
        
        System.out.println("Press any key to make the communism come alive");
        String s = kbin.next();
        for (int i = 0; i < pixels; i++) {
            String nothing = "AAAAAAz";
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
    }

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
