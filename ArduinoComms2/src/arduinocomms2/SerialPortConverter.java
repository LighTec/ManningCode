/*
 * This program was designed for a arduino Uno, or any similar device that can communicate over 
 * serial USB.
 * ---------------------------------------------------------
 * This program is designed to have the arduino itself run custom code, so do not expect
 * that you can run this on any random arduino. The code required to get the arduino to work
 * can be found as a .ino file recognizable by the arduino IDE, within the zip package of this
 * program.
 */
package arduinocomms2;

import com.fazecast.jSerialComm.SerialPort;
import javafx.util.StringConverter;

/**
 * Used to allow SerialPort object to be represented in a JavaFX combo box.
 * @author kell-gigabyte
 */
public class SerialPortConverter extends StringConverter<SerialPort>{

    @Override
    public String toString(SerialPort port) {
        return port.getSystemPortName();
    }

    @Override
    public SerialPort fromString(String string) {
        return SerialPort.getCommPort(string);
    }
    
}
