package com.procergs.privatelabs.infra;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;

public class AppBD<ED extends AppED<PK>, PK> {

    private Class<ED> entityClass;
    private String namedQueryConsulta;
    private String queryExclui;
    private String queryExcluiLista;

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
    public AppBD() {
      ParameterizedType genericSuperclass = null;
      if(getClass().getGenericSuperclass() instanceof ParameterizedType){
        genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
      }else if(getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType){
        genericSuperclass = (ParameterizedType)getClass().getSuperclass().getGenericSuperclass();
      }
      if(genericSuperclass == null){
        throw new RuntimeException("nao foi possivel inferir o tipo generico");
      }
        entityClass = (Class<ED>) genericSuperclass.getActualTypeArguments()[0];
        namedQueryConsulta = entityClass.getSimpleName() + ".consulta";
        queryExclui = "DELETE " + entityClass.getSimpleName() + " e WHERE e.id = :id";
        queryExcluiLista = "DELETE " + entityClass.getSimpleName() + " e WHERE e.id IN :ids";
    }

    @SuppressWarnings("unchecked")
    public ED consulta(PK id) {
        Query query = entityManager.createNamedQuery(namedQueryConsulta);
        query.setParameter("id", id);
        return (ED) query.getSingleResult();
    }

    public ED inclui(ED ed) {
        entityManager.persist(ed);
        entityManager.flush();
        return ed;
    }

    public ED altera(ED ed) {
        ed = entityManager.merge(ed);
        entityManager.flush();
        return ed;
    }

    public void exclui(ED ed) {
        Query query = entityManager.createQuery(queryExclui);
        query.setParameter("id", ed.getId());
        query.executeUpdate();
    }

    public void exclui(List<ED> eds) {
        Set<PK> ids = new HashSet<>();
        for (ED ed : eds) {
            ids.add(ed.getId());
        }

        Query query = entityManager.createQuery(queryExcluiLista);
        query.setParameter("ids", ids);
        query.executeUpdate();
    }

    public List<ED> lista(ED ped) {
        DetachedCriteria dc = montaCriterios(ped);
        return findByCriteria(dc, 0, 50);
    }

    public int conta(ED ped) {
        Criteria criteria = montaCriterios(ped).getExecutableCriteria(getSession());
        criteria.setProjection(Projections.count(getSession().getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName()));
        Long result = (Long) criteria.uniqueResult();
        return result.intValue();
    }

    public DetachedCriteria montaCriterios(ED ped) {
        DetachedCriteria dc = getDetachedCriteria();
        adicionaRestricoes(ped, dc);
        return dc;
    }

    public DetachedCriteria montaCriterios(ED ped, DetachedCriteria dc) {
        adicionaRestricoes(ped, dc);
        return dc;
    }

    public void adicionaRestricoes(ED ped, DetachedCriteria dc) {
        dc.add(Example.create(ped).enableLike(MatchMode.ANYWHERE).ignoreCase());
    }

    @SuppressWarnings("unchecked")
    public List<ED> findByCriteria(DetachedCriteria dc, int first, int maxResult) {
        Criteria criteria = dc.getExecutableCriteria(getSession());
        criteria.setFirstResult(first);
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }

    public DetachedCriteria getDetachedCriteria() {
        return DetachedCriteria.forClass(entityClass);
    }

    // Getters & Setters

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Session getSession() {
        Session session = entityManager.unwrap(Session.class);
        return session;
    }

}
