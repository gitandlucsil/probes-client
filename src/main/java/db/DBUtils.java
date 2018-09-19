/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import models.Probe;

/**
 *
 * @author andre
 */
public class DBUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProbesTU");
    private static EntityManager em = null;
    private static EntityTransaction tx = null;
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    public EntityTransaction getEntityTransaction(){
        return tx;
    }
    
    public void newEntityManager(){
        em = emf.createEntityManager();
    }
    
    public void beginNewTransaction(){
        tx = em.getTransaction();
        tx.begin();
    }
    
    public void doPersistProbes(Probe probe){
        em.persist(probe);
        tx.commit();
    }
    
    public static void shutdownEntityManagerFactory() {
        emf.close();
    }
    
    public void shutdownEntityManager() {
        em.close();
    }
}
