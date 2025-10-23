package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class daoProduto {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CatalogoProdutosPU");
    EntityManager em = emf.createEntityManager();
    
    public boolean inserir(produto p) {
        em.getTransaction().begin();
        try{
            em.persist(p);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
    public List<produto> listar(){
        Query consulta= em.createQuery("select p from produto p");
        return consulta.getResultList();
    }
    
    public boolean editar(produto p) {
        em.getTransaction().begin();
        try {
            em.merge(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e){
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public boolean excluir(produto p) {
        em.getTransaction().begin();
        try {
            em.remove(p);
            em.getTransaction().commit();
            return true;
        }catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}