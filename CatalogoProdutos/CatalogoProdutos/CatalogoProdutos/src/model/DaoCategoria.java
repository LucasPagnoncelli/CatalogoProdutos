/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo Stahnke
 */
public class DaoCategoria {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoProdutosINFO23BPU");
    private EntityManager em = emf.createEntityManager();

    public boolean inserir(Categoria c) {
        em.getTransaction().begin();
        try {
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

}
