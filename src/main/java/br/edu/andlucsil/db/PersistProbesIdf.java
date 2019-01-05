/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.db;

import br.edu.andlucsil.models.ProbesIdf;

/**
 *
 * @author andre
 */
public class PersistProbesIdf {
 
        public PersistProbesIdf(ProbesIdf[] probes_idfs) {
        
        DBUtils.newEntityManagerFactory("ProbesValues");
        DBUtils.newEntityManager();
        for (ProbesIdf p : probes_idfs) {
            DBUtils.beginNewTransaction();
            DBUtils.doPersistProbesIdfs(p);
        }
        DBUtils.shutdownEntityManager();
        DBUtils.shutdownEntityManagerFactory();
    }
    
}
