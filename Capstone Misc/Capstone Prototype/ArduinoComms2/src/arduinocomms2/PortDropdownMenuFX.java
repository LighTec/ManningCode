package arduinocomms2;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * A modified version of the PortDropdownMenu for javaFX.
 *
 * @author kell-gigabyte
 */
public class PortDropdownMenuFX extends ComboBox<SerialPort> {

    /**
     * WARNING: CALL THIS METHOD TO INITIALIZE THE COMBO BOX. failing to do so
     * will result in an empty combo box, and an unhappy program.
     */
    public void refreshMenu() {
        ObservableList list = FXCollections.observableArrayList();
        SerialPort[] ports = SerialPort.getCommPorts();
        list.addAll(Arrays.asList(ports));
        this.setItems(list);
        //this.getSelectionModel().selectFirst();              // causes NullPointerExceptions when used, thou are warned
        this.setConverter(new SerialPortConverter());
    }
}
