package com.biblioteca.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    // O nome "biblioteca-pu" deve ser o mesmo que você colocar no seu persistence.xml
    private static final EntityManagerFactory FACTORY = 
        Persistence.createEntityManagerFactory("biblioteca-pu");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}