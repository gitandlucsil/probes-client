/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import db.DBUtils;
import models.ProbesValues;

/**
 *
 * @author andre
 */
public class JsonToObject {

    public JsonToObject(String json) {
            System.out.println("------------------------------------------------");
            System.out.println("Vai criar o JSON!");
            Gson gson = new Gson();
            ProbesValues[] probes_values = gson.fromJson(json,ProbesValues[].class);
            System.out.println(json);
            System.out.println("Valores do json: ");
            System.out.println(probes_values[0].getId_value());
            System.out.println(probes_values[0].getRead_value());
            System.out.println(probes_values[1].getId_value());
            System.out.println(probes_values[1].getRead_value());
            System.out.println(probes_values[2].getId_value());
            System.out.println(probes_values[2].getRead_value());
            System.out.println(probes_values[3].getId_value());
            System.out.println(probes_values[3].getRead_value());
            //System.out.println("t1: "+probes.getTemperature1()+", t2: "+probes.getTemperature2()+", h1: "+probes.getHumidity1()+", h2: "+probes.getHumidity2());
            System.out.println("Salvando no banco! ");
            /*DBUtils.newEntityManagerFactory("ProbesTU");
            DBUtils.newEntityManager();
            DBUtils.beginNewTransaction();
            DBUtils.doPersistProbes(probes);
            DBUtils.shutdownEntityManager();
            DBUtils.shutdownEntityManagerFactory();*/
            System.out.println("------------------------------------------------");
            
    }
}
