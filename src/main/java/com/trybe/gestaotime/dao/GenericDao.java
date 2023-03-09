package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.MappedSuperclass;
import javax.persistence.Persistence;

/**Classe abstrata GenericDao.*/
@MappedSuperclass
public abstract class GenericDao<T, I extends Serializable> {
  private Class<T> classe;
  private EntityManagerFactory emf;

  public GenericDao(Class<T> classe) {
    this.classe = classe;
    this.emf = Persistence.createEntityManagerFactory("crudHibernatePU");
  }
  
  /**Método de salvar. */
  public void salvar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }
  
  /**Método de atualizar. */
  public void editar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
    em.close();
  }
  
  /**Método de deletar. */
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    T entity = em.find(classe, id);
    em.remove(entity);
    em.getTransaction().commit();
    em.close();
  }
  
  /**Método de listar por Id. */
  public T pegar(Long id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    T entity = em.find(classe, id);
    em.close();
    return entity;
  }
  
  /**Método de listar tudo. */
  public List<T> listar() {
    EntityManager em = emf.createEntityManager();
    List<T> entity = em.createQuery("from Servidor", classe).getResultList();
    em.close();
    return entity;
  }
}