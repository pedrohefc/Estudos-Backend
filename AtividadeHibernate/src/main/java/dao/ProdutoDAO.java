package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import doMain.Produto;

public class ProdutoDAO {

    private EntityManagerFactory emf;

    public ProdutoDAO() {
        emf = Persistence.createEntityManagerFactory("ExemploJPA");
    }

    public Produto cadastrar(Produto produto) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(produto); // 🔥 salva no banco

            em.getTransaction().commit();

            return produto;

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }
}
