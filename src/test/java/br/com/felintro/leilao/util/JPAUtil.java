package br.com.felintro.leilao.util;
/*
 * @author allfel
 *
 * Data: 26/01/2023
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("testes_integracao");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
