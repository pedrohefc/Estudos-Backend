package exemplo;

import exemplo.model.Cliente;
import exemplo.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        Cliente cliente = new Cliente(1L, "Pedro");

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        em.close();

        System.out.println("Cliente salvo com sucesso!");
    }
}
