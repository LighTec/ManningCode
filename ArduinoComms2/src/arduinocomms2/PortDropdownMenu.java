package arduinocomms2;

import com.fazecast.jSerialComm.*;
import javax.swing.*;

public class PortDropdownMenu extends JComboBox<String> {

    public void refreshMenu() {
        this.removeAllItems();
        SerialPort[] portNames = SerialPort.getCommPorts();
        for (int i = 0; i < portNames.length; i++) {
            this.addItem(portNames[i].getSystemPortName());
        }
    }
}
