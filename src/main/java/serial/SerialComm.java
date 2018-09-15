/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class SerialComm {

    public SerialComm() {
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        PacketListener listener = new PacketListener();
        comPort.addDataListener(listener);
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        /*comPort.removeDataListener();
        comPort.closePort();*/
    }
    
    
    
}
