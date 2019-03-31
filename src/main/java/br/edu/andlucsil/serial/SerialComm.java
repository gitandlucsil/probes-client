/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.serial;

import com.fazecast.jSerialComm.SerialPort;

/**
 * @author André Lucas Silva
 */
public class SerialComm {

    public SerialComm() {
        SerialPort comPort = SerialPort.getCommPorts()[0];/*Recebe a primeira porta serial disponível*/
        comPort.openPort();                               /*Abre a conexão com a porta*/
        PacketListener listener = new PacketListener();
        comPort.addDataListener(listener);
        System.out.println("Porta aberta!");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        /*comPort.removeDataListener();
        comPort.closePort();*/
    }
    
    
    
}
