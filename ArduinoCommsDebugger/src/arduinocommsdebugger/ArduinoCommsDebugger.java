/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arduinocommsdebugger;

import arduino.Arduino;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class ArduinoCommsDebugger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        Arduino arduino = new Arduino(commPort.getSystemPortName(), 230400); //enter the port name here, and ensure that Arduino is connected, otherwise exception will be thrown.
        arduino.openConnection();
        
         System.out.println("Enter pixel FFF, red FF, green FF, blue FF then a z, like this: FFFAABBCCz");
        String input = kbin.nextLine();
        while (true) {
            System.out.println(input);
            arduino.serialWrite(input);
           // System.out.println(arduino.serialRead());
            input = kbin.nextLine();
        }
    }

}
