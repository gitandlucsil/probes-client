package serial;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortPacketListener;
import json.JsonToObject;

public final class PacketListener implements SerialPortPacketListener
{

    public PacketListener() {
    }
    
   @Override
   public int getListeningEvents()
   {
       return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
   }

   @Override
   public int getPacketSize()
   {
       return 125;
   }

   @Override
   public void serialEvent(SerialPortEvent event)
   {
      byte[] newData = event.getReceivedData();
      //System.out.println("Received data of size: " + newData.length);
      String json_from_probes = "";
      for (int i = 0; i < newData.length; ++i){
         //System.out.print((char)newData[i]);
         json_from_probes += (char)newData[i];
      }
      //System.out.println(json_from_probes);
      //System.out.println("\n");
      if(!"".equals(json_from_probes)){ //Se a mensagem não estiver vazia
          if(json_from_probes.charAt(0) == '[' && json_from_probes.charAt(getPacketSize()-1) == ']'){//Se começar e terminar com sinalizacao de vetor []
              if(json_from_probes.charAt(1) == '{' && json_from_probes.charAt(getPacketSize()-2) == '}'){
                JsonToObject jobj = new JsonToObject(json_from_probes); 
              }
          }
      }
   }
}