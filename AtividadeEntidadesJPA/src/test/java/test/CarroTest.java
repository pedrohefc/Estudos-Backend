package test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import domain.Carro;
import domain.Marca;
import domain.Acessorio;

public class CarroTest {

    @Test
    public void cadastrar() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Criando Marca
        Marca marca = new Marca();
        marca.setNome("Toyota");

        em.persist(marca);

        // Criando Acessorio
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Ar Condicionado");
        acessorio.setDescricao("Ar condicionado digital");

        em.persist(acessorio);

        // Criando Carro
        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setAno(2026);
        carro.setMarca(marca);
        carro.getAcessorios().add(acessorio);

        em.persist(carro);

        em.getTransaction().commit();

        assertNotNull(carro.getId());

        em.close();
        emf.close();
    }
}
