/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.dao.impl;

import com.onlinemart.utils.SessionUtil;
import java.util.List;


/**
 *
 * @author KBashyal
 */


public abstract class AbstractDAO<T> extends SessionUtil
{
    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    public AbstractDAO() {
    }
    
    

//    protected abstract EntityManager getEntityManager();

    public void create(T entity)
    {
        getSession().persist(entity);
    }

    public void edit(T entity)
    {
        getSession().merge(entity);
    }

    public void remove(T entity)
    {
//        getSession().remove(getSession().merge(entity));
    }

    public T find(Object id)
    {
//        return getSession().find(entityClass, id);
        return null;
    }
    
    

    public List<T> findAll()
    {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        return getEntityManager().createQuery(cq).getResultList();
        return null;
    }

    public List<T> findRange(int[] range)
    {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        cq.select(cq.from(entityClass));
//        javax.persistence.Query q = getEntityManager().createQuery(cq);
//        q.setMaxResults(range[1] - range[0] + 1);
//        q.setFirstResult(range[0]);
//        return q.getResultList();
        return null;
    }

    public int count()
    {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
//        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
//        javax.persistence.Query q = getEntityManager().createQuery(cq);
//        return ((Long) q.getSingleResult()).intValue();
        return 0;
    }
    
}
