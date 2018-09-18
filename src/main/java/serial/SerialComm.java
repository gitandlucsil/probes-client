/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import com.fazecast.jSerialComm.SerialPort;

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
        }catch(InterruptedException e){
        }
        /*comPort.removeDataListener();
        comPort.closePort();*/
    }
    
    
    
}
