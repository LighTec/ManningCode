package arduinocomms2;

import java.awt.Dimension;
import java.io.PrintWriter;
import java.util.Scanner;

import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arduino {

    private SerialPort comPort;
    private String portDescription;
    private int baud_rate;

    /**
     * Do not use, please. Unless you know what you are doing.
     */
    public Arduino() {
        //empty constructor if port undecided
    }

     /**
     * Remember to set the baud rate later on if you're planning on using this!
     *
     * @param portDescription
     */
    public Arduino(String portDescription) {
        //make sure to set baud rate after
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

     /**
     * Sets the arduino object to work upon the described port at the set rate.
     *
     * @param portDescription
     * @param baud_rate
     */
    public Arduino(String portDescription, int baud_rate) {
        //preferred constructor
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
        this.baud_rate = baud_rate;
        comPort.setBaudRate(this.baud_rate);
    }

    /**
     * Opens a connection on the serial port for the arduino. Pops up an alert
     * box if it fails, and return false.
     *
     * @return connectionSucess/failure
     */
    public boolean openConnection() {
        if (comPort.openPort()) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            return true;
        } else {
            AlertBox alert = new AlertBox(new Dimension(400, 100), "Error Connecting", "Try Another port");
            alert.display();
            return false;
        }
    }

    /**
     * Closes the port between the arduino and computer.
     */
    public void closeConnection() {
        comPort.closePort();
    }

    /**
     * Sets the description of the port.
     *
     * @param portDescription
     */
    public void setPortDescription(String portDescription) {
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

    /**
     * Sets the baud rate of the port, if you do not understand this, set to 9200. 
     * That is the default for Arduinos. Pretty much acts as the speed both sides are expecting to receive data.
     *
     * @param baud_rate
     */
    public void setBaudRate(int baud_rate) {
        this.baud_rate = baud_rate;
        comPort.setBaudRate(this.baud_rate);
    }

    public String getPortDescription() {
        return portDescription;
    }

    public SerialPort getSerialPort() {
        return comPort;
    }

     /**
     * Reads everything currently in the port, and turns it into a String. If
     * data is constantly incoming, this method will act as an infinite loop, so
     * be careful.
     *
     * @return
     */
    public String serialRead() {
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        String out = "";
        Scanner in = new Scanner(comPort.getInputStream());
        try {
            while (in.hasNext()) {
                out += (in.next() + "\n");
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            in.close();
            System.out.println("Read err");
        }
        return out;
    }

    /**
     * Reads a String from the port, cuts off the String after a specified amount of chars.
     *
     * @param limit
     * @return
     */
    public String serialRead(int limit) {
        //in case of unlimited incoming data, set a limit for number of readings
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        String out = "";
        int count = 0;
        Scanner in = new Scanner(comPort.getInputStream());
        try {
            while (in.hasNext() && count <= limit) {
                out += (in.next() + "\n");
                count++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * Writes String s to the port.
     *
     * @param s
     */
    public void serialWrite(String s) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        pout.print(s);
        pout.flush();

    }
    
    /**
     *  Takes an array of Strings, then compresses them together into a massive String to send to
     * the other device. Recommended to use if you are updating a display of LEDs, individual LED updates take
     * a long time, 20 updates per second max.
     * @param s 
     */
    public void serialWrite(String[] s){
        String str = "";
        for(String sTemp : s){
            str += sTemp;
        }
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        pout.print(str);
        pout.flush();
    }
    
    public void byteArrayWrite(byte[] b){
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        OutputStream pout = comPort.getOutputStream();
        try {
            pout.write(b);
            pout.flush();
        } catch (IOException ex) {
        }
        
    }
    
     public void byteArrayWrite(byte[] b, int off, int len){
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        OutputStream pout = comPort.getOutputStream();
        try {
            pout.write(b, off, len);
            pout.flush();
        } catch (IOException ex) {
        }
        
    }

    /**
     * Writes an specified amount of chars, beginning at String s to the port. Waits a delay between
     * each char sent.
     *
     * @param s
     * @param noOfChars
     * @param delay
     */
    public void serialWrite(String s, int noOfChars, int delay) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        for (int i = 0; i < s.length(); i += noOfChars) {
            pout.write(s.substring(i, i + noOfChars));
            pout.flush();
            System.out.println(s.substring(i, i + noOfChars));
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
            }
        }
        pout.write(noOfChars);
        pout.flush();

    }

    /**
     * Writes char c to the port.
     *
     * @param c
     */
    public void serialWrite(char c) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        pout.write(c);
        pout.flush();
    }

    /**
     * Writes char c to the port, then delays the program for an amount milliseconds.
     *
     * @param c
     * @param delay
     */
    public void serialWrite(char c, int delay) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        PrintWriter pout = new PrintWriter(comPort.getOutputStream());
        pout.write(c);
        pout.flush();
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
        }
    }
}
