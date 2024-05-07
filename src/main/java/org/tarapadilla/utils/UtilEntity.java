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
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    public static void saveChanges(EntityManager entityManager) {
        try {
            if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
