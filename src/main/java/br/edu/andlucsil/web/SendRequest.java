/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.web;

import br.edu.andlucsil.model.Probe;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
//import com.sun.jesey.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author andre
 */
public class SendRequest {

    public SendRequest(Probe probe) throws MalformedURLException {
        try {
            String request_url = "http://localhost:8080/probedesc/" + probe.getId() + "/probevalue";
            String payload = "{\"read_value\":" + probe.getRead_value() + "}";
            Client client = Client.create();
            WebResource webResource = client.resource(request_url);
            ClientResponse response = webResource.type("application/json").post(ClientResponse.class, payload);
            if (response.getStatus() != 200) {
                throw new RuntimeException("HTTP erro : " + response.getStatus());
            }
            /*System.out.println("Saida do servidor: .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);*/
        } catch (RuntimeException e) {
        }
        /*Sem o Jersey*/
        /*try {
            String request_url = "http://localhost:8080/probedesc/" + probe.getId() + "/probevalue";
            String payload = "{\"read_value\":" + probe.getRead_value() + "}";
            //System.out.println(request_url);
            //System.out.println(payload);
            URL url = new URL(request_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(payload);
            writer.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            System.out.println(jsonString.toString());
        } catch (IOException ex) {
            Logger.getLogger(SendRequest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
