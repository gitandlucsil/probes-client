/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author andre
 */
public class HibernateDAO <T>{
    
    protected Class<T> clazz;
    protected Session session;
    private SessionFactory sessionFactory;

    public HibernateDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    public void delete(T entity){
        getSession().delete(entity);
    }
    
    public void update(T entity){
        getSession().update(entity);
    }
    
    public void save(T entity){
        getSession().save(entity);
    }
    
    public void saveOrUpdate(T entity){
        getSession().saveOrUpdate(entity);
    }
    
    public T load(Serializable id){
        return(T) getSession().load(this.clazz, id);
    }
    
    public T get(Serializable id){
        return (T) getSession().get(this.clazz, id);
    }
    
    protected Query createQuery(String query){
        return getSession().createQuery(query);
    }
    
    protected Criteria createCriteria(){
        return getSession().createCriteria(this.clazz);
    }
    
    public Session getSession(){
        if(sessionFactory != null){
            session = sessionFactory.getCurrentSession();
        }
        if(session == null){
            throw new RuntimeException("Sessão do Hibernate é nula!");
        }
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
