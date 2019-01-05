/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.db;

import br.edu.andlucsil.models.ProbesValues;


/**
 *
 * @author andre
 */
public class PersistProbesValues {

    public PersistProbesValues(ProbesValues[] probes_values) {
        
        DBUtils.newEntityManagerFactory("ProbesValues");
        DBUtils.newEntityManager();
        for (ProbesValues p : probes_values) {
            //System.out.println("data: "+p.getDate()+", hora: "+p.getTime());
            DBUtils.beginNewTransaction();
            DBUtils.doPersistProbesValues(p);
        }
        DBUtils.shutdownEntityManager();
        DBUtils.shutdownEntityManagerFactory();
    }

}
