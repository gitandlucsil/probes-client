/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.andlucsil.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.FlushMode;

/**
 *
 * @author andre
 * @param <T>
 */
public class DAO<T> {

	private final Class<T> modelClass;

	public DAO(Class<T> modelClass) {
		this.modelClass = modelClass;
	}
	
	public void delete(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		try {
                        em.setFlushMode(FlushModeType.COMMIT);
			em.remove(em.merge(t));
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();	
		}		
	}
	
	public List<T> findAll() {
		EntityManager em = new JPAUtil().getEntityManager();
                em.getEntityManagerFactory().getCache().evictAll();
		List<T> lista = null;
		try {
			CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(modelClass);
			query.select(query.from(modelClass));
			lista = em.createQuery(query).getResultList();
		} finally {
			em.close();
		}
		return lista;
	}

	public T findById(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getEntityManagerFactory().getCache().evictAll();
                T instancia = null;
		try {
			instancia = em.find(modelClass, id);
		} finally {
			em.close();
		}
		return instancia;
	}	
	
	public void insert(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		try {
                        //em.setFlushMode(FlushModeType.COMMIT);
			em.persist(t);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();	
		}
	}

	public void update(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		try {
                        //em.setFlushMode(FlushModeType.COMMIT);
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
