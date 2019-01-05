package br.edu.andlucsil.serial;

import br.edu.andlucsil.db.PersistProbesIdf;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortPacketListener;
import br.edu.andlucsil.json.ProbesValuesJsonToObj;
import br.edu.andlucsil.models.ProbesIdf;

public final class PacketListener implements SerialPortPacketListener
{

    public PacketListener() {
        ProbesIdf[] p_idf = new ProbesIdf[4];
        p_idf[0] = new ProbesIdf(1,"T1");
        p_idf[1] = new ProbesIdf(2,"U1");
        p_idf[2] = new ProbesIdf(3,"T2");
        p_idf[3] = new ProbesIdf(4,"U2");
        PersistProbesIdf p_p_idf = new PersistProbesIdf(p_idf);
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
                ProbesValuesJsonToObj jobj = new ProbesValuesJsonToObj(json_from_probes); 
              }
          }
      }
   }
}