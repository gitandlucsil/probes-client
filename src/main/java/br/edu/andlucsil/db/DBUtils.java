/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import br.edu.andlucsil.models.ProbesValues;

/**
 *
 * @author andre
 */
public class DBUtils{
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    private static EntityTransaction tx = null;
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    
    public static EntityManager getEntityManager(){
        return em;
    }
    
    public static EntityTransaction getEntityTransaction(){
        return tx;
    }
    
    public static void newEntityManagerFactory(String name){
        emf = Persistence.createEntityManagerFactory(name);
    }
    
    public static void newEntityManager(){
        em = emf.createEntityManager();
    }
    
    public static void beginNewTransaction(){
        tx = em.getTransaction();
        tx.begin();
    }
    
    public static void doPersistProbes(ProbesValues probe){
        em.persist(probe);
        tx.commit();
    }
    
    public static void shutdownEntityManagerFactory() {
        emf.close();
    }
    
    public static void shutdownEntityManager() {
        em.close();
    }
    
}

