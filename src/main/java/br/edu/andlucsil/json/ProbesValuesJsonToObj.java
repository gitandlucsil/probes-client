/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.json;

import com.google.gson.Gson;
import br.edu.andlucsil.db.PersistProbesValues;
import br.edu.andlucsil.models.ProbesValues;

/**
 *
 * @author andre
 */
public class ProbesValuesJsonToObj {

    public ProbesValuesJsonToObj(String json) {
            Gson gson = new Gson();
            ProbesValues[] probes_values = gson.fromJson(json,ProbesValues[].class);
            PersistProbesValues p_p_v = new PersistProbesValues(probes_values);
    }
}
