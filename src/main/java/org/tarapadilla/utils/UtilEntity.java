package org.tarapadilla.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtilEntity {


    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    public static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
