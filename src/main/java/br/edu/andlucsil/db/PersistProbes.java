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
public class PersistProbes {
    
    private DAO<ProbesValues> dao;

    public PersistProbes(ProbesValues[] probes_values) {
        
        dao = new DAO<>(ProbesValues.class);
        for (ProbesValues p : probes_values) {
            dao.update(p);
        }
    }

}
