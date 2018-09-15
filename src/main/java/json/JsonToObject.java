/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import models.Probe;

/**
 *
 * @author andre
 */
public class JsonToObject {

    public JsonToObject(String json) {
            System.out.println("Vai criar o JSON!");
            Gson gson = new Gson();
            Probe probes = gson.fromJson(json, Probe.class);
            System.out.println(json);
    }
}
