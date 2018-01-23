package arduino;

import java.awt.Dimension;
import java.io.PrintWriter;
import java.util.Scanner;

import com.fazecast.jSerialComm.*;

public class Arduino {

    private SerialPort comPort;
    private String portDescription;
    private int baud_rate;
    
    private PrintWriter pout;

    /**
     * Do not use, please. Unless you know what you are doing.
     */
    public Arduino() {
        //empty constructor if port undecided
    }

    /**
     * Remember to set the baud rate later on if you're planning on using this!
     * @param portDescription 
     */
    public Arduino(String portDescription) {
        //make sure to set baud rate after
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

    /**
     * Sets the arduino object to work upon the described port at the set rate.
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
     * Call after the connection opens in order to print to the port.
     */
    public void initWriter(){
        this.pout = new PrintWriter(comPort.getOutputStream());
    }
    
    /**
     * Opens a connection on the serial port for the arduino. Pops up an alert box if it fails, and return false.
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
     * Sets the description of the port,.
     * @param portDescription 
     */
    public void setPortDescription(String portDescription) {
        this.portDescription = portDescription;
        comPort = SerialPort.getCommPort(this.portDescription);
    }

    /**
     * Sets the baus rate of the port, if you do not understand this set to 9200.
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
     * Reads everything currently in the port, and turns it into a String. If data is constantly incoming, 
     * this method will act as an infinite loop, so be careful.
     * @return 
     */
    public String serialRead() {
        //will be an infinite loop if incoming data is not bound
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        String out = "";
        Scanner in = new Scanner(comPort.getInputStream());
        try {
            while (in.hasNext()) {
                out += (in.next() + "\n");
            }
            in.close();
        } catch (Exception e) {
        }
        return out;
    }

    /**
     * Reads a String from the port, cuts off the String after l chars.
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
        }
        return out;
    }

    /**
     * Writes String s to the port.
     * @param s 
     */
    public void serialWrite(String s) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        this.pout = new PrintWriter(comPort.getOutputStream());
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        this.pout.print(s);
        this.pout.flush();

    }
    
    /**
     * Prints String s to the port, however doesn't have any failsafe so it is fast. Beware, this method
     * may cause bugs.
     * @param s 
     */
    public void fastSerialWrite(String s) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        this.pout = new PrintWriter(comPort.getOutputStream());
        this.pout.print(s);
        this.pout.flush();

    }

    /**
     * Writes n chars, beginning at String s to the port. Waits a delay between each char sent.
     * @param s
     * @param noOfChars
     * @param delay 
     */
    public void serialWrite(String s, int noOfChars, int delay) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        this.pout = new PrintWriter(comPort.getOutputStream());
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        for (int i = 0; i < s.length(); i += noOfChars) {
            this.pout.write(s.substring(i, i + noOfChars));
            this.pout.flush();
            System.out.println(s.substring(i, i + noOfChars));
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
            }
        }
        this.pout.write(noOfChars);
        this.pout.flush();

    }

    /**
     * Writes char c to the port.
     * @param c 
     */
    public void serialWrite(char c) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        this.pout = new PrintWriter(comPort.getOutputStream());
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        this.pout.write(c);
        this.pout.flush();
    }

    /**
     * Writes char c to the port, then delays the program d milliseconds.
     * @param c
     * @param delay 
     */
    public void serialWrite(char c, int delay) {
        //writes the entire string at once.
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        this.pout = new PrintWriter(comPort.getOutputStream());
        try {
            Thread.sleep(5);
        } catch (Exception e) {
        }
        this.pout.write(c);
        this.pout.flush();
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
        }
    }
}
