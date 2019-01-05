/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.json;

import com.google.gson.Gson;
import br.edu.andlucsil.db.DBUtils;
import br.edu.andlucsil.models.ProbesValues;

/**
 *
 * @author andre
 */
public class JsonToObject {

    public JsonToObject(String json) {
            //System.out.println("------------------------------------------------");
            System.out.println("Vai criar o JSON!");
            Gson gson = new Gson();
            ProbesValues[] probes_values = gson.fromJson(json,ProbesValues[].class);
            /*System.out.println("Valores do json: ");
            System.out.println(probes_values[0].getId_value());
            System.out.println(probes_values[0].getRead_value());
            System.out.println(probes_values[1].getId_value());
            System.out.println(probes_values[1].getRead_value());
            System.out.println(probes_values[2].getId_value());
            System.out.println(probes_values[2].getRead_value());
            System.out.println(probes_values[3].getId_value());
            System.out.println(probes_values[3].getRead_value());*/
            //System.out.println("Salvando no banco! ");
            DBUtils.newEntityManagerFactory("ProbesValues");
            DBUtils.newEntityManager();
            for (ProbesValues p : probes_values){ 
                ProbesValues p_v = new ProbesValues();
                p_v.setId_value(p.getId_value());
                p_v.setRead_value(p.getRead_value());
                System.out.println("id: "+p_v.getId()+", p_id: "+p_v.getId_value()+", read_value: "+p_v.getRead_value());
                DBUtils.beginNewTransaction();
                DBUtils.doPersistProbes(p_v);
            }
            DBUtils.shutdownEntityManager();
            DBUtils.shutdownEntityManagerFactory();
            //System.out.println("------------------------------------------------");
            
    }
}
