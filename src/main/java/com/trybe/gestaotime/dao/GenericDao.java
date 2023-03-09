package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**Classe abstrata GenericDao que estende Serializable. */
public abstract class GenericDao<T, I extends Serializable> {

  private final Class<T> entityClass;
  private final EntityManager em = Persistence.createEntityManagerFactory("crudHibernatePU")
      .createEntityManager();

  /**Método Construtor. */
  public GenericDao(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  /**Metodo para salvar. */
  public void salvar(T entity) {
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(entity);
    transaction.commit();
  }

  /**Metodo para atualizar. */
  public void editar(T entity) {
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.merge(entity);
    transaction.commit();
  }

  /**Metodo para remover.*/
  public void deletar(Long id) {
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    T entity = em.find(entityClass, id);
    em.remove(entity);
    transaction.commit();
  }

  /**Metodo de buscar por id.*/
  public T pegar(Long id) {
    return em.find(entityClass, id);
  }

  /**Metodo de listar todos.*/
  public List<T> listar() {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
    Root<T> root = criteriaQuery.from(entityClass);
    criteriaQuery.select(root);
    return em.createQuery(criteriaQuery).getResultList();
  }
}