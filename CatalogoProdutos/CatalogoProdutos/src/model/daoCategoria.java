package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class daoCategoria {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoProdutosPU");
    EntityManager em = emf.createEntityManager();

    public boolean cadastrarCategoria(categoria c) {
        em.getTransaction().begin();
        try{
            em.persist(c);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public List<categoria> listar(){
        Query consulta= em.createQuery("select c from categoria c");
        return consulta.getResultList();
    }
    
    public boolean excluir(categoria c) {
        em.getTransaction().begin();
        try{
            em.remove(c);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean editar (categoria c) {
        em.getTransaction().begin();
        try {
            em.merge(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public categoria selecionarCategoria (String nome) {
        try{
            Query consulta = em.createQuery("select c from categoria c where c.nome =:n");
            consulta.setParameter("n",nome );
            return (categoria) consulta.getSingleResult();
        }catch (NoResultException e) {
            return null;
        }
    }
}