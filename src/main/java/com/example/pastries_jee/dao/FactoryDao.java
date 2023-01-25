package com.example.pastries_jee.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public final class FactoryDao {

    private static final EntityManager em = Persistence.createEntityManagerFactory("persistence-unit").createEntityManager();

    public static PastryDao getPastryDao() {
        return new PastryDao(em);
    }
}
