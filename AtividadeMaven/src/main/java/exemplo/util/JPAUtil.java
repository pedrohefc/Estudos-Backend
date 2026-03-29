package exemplo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("meu-persistence");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
