/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.json;

import br.edu.andlucsil.model.Probe;
import br.edu.andlucsil.web.SendRequest;
import com.google.gson.Gson;
import java.net.MalformedURLException;

/**
 *
 * @author andre
 */
public class JsonToObj {

    public JsonToObj(String json) throws MalformedURLException {
        Gson gson = new Gson();
        Probe[] probes = gson.fromJson(json,Probe[].class);
        for(Probe p : probes){
            System.out.println(p.getId() + " - " + p.getRead_value());
            new SendRequest(p);
        }
    }
    
    
}
