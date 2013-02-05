package org.krohm.tagcontainer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDao<T, K> {

    //protected abstract EntityManager getEntityManager();
    @PersistenceContext//(unitName="central")
    protected EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericDao.class);
    // Those are not really requested, only there to manage java poor 
    // generics reflexivity
    private Class clazzT;
    private Class clazzK;

    public GenericDao(Class<T> clazzT, Class<K> clazzK) {
        this.clazzT = clazzT;
        this.clazzK = clazzK;
    }

    public GenericDao(Class<T> clazz) {
        this.clazzT = clazzT;
        this.clazzK = Object.class;
    }

    public GenericDao() {
    }

    @Transactional(readOnly = true)
    public T findById(Class<T> typeClass, K id) {
        return (T) em.find(typeClass, id);
    }

    @Transactional(readOnly = true)
    public T findById(K id) {
        return (T) em.find(clazzT, id);
    }

    @Transactional
    public void flush() {
        em.flush();
    }

    @Transactional
    public void create(T o) {
        em.persist(o);
    }

    @Transactional
    public void update(T o) {
        em.merge(o);
    }

    @Transactional
    public void delete(Class<T> typeClass, K id) {
        Object o = em.getReference(typeClass, id);
        em.remove(o);
    }
}
