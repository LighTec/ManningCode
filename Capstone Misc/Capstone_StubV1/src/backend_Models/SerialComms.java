/*
 * Created By Kell Larson for the Computer Science AP program during school year 2016/2017. Please ask before copying code.
 */
package backend_Models;

import arduinocomms2.Arduino;
import com.fazecast.jSerialComm.SerialPort;
import frontend_ViewController.Settings;
import java.io.Closeable;

/**
 * Talks to whatever is controlling the LEDs. uses the JArduino library to do
 * so.
 *
 * Takes the zero index from a string array shared between itself and
 * PixelControl, then chews through it, one string at a time. The string array
 * acts as a buffer between the 2 threads, and this class just grabs the index 0
 * string within the array, then moves the rest down 1 index for the next time
 * around. Then, it parses the string into 4 int values, resulting in a LED
 * position, and RGB values. Then it sends it off through serial port
 * communication to the arduino, or whatever is plugged in.
 *
 * @author Kell
 */
public class SerialComms implements Closeable {

    public SerialComms(Settings settings) {
    }

    private Arduino arduino;

    public void printPortsAvailable(SerialPort[] ports) {
        for (int i = 0; i < ports.length; i++) {

            System.out.println("Port " + i + "\t\t" + ports[i].getSystemPortName());
            System.out.println("Baud rate: " + ports[i].getBaudRate());
        }
    }

    @Override
    public void close() {
        this.arduino.closeConnection();
    }

    public void write(byte[] b) {
    }

    public void write(byte[] b, int off, int len) {
    }

    public void writeChars(String s) {
    }

    public void writeShort(short s) {
    }

    public void writeChar(char c) {
        this.arduino.serialWrite(c);
    }
}
