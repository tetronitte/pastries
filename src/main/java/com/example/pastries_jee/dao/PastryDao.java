package com.example.pastries_jee.dao;

import com.example.pastries_jee.entities.Pastry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class PastryDao implements GenericDao<Pastry> {

    private EntityManager em;

    public PastryDao(EntityManager em) {
        this.em = em;
    }

    private void startTransaction() {
        em.getTransaction().begin();
    }

    private void endTransaction() {
        em.getTransaction().commit();
    }

    private void rollback() {
        em.getTransaction().rollback();
    }

    public Optional<Pastry> getByName(String name) {
        TypedQuery<Pastry> query = em.createQuery("SELECT p FROM Pastry p WHERE p.name = :name", Pastry.class);
        query.setParameter("name", name);
        Pastry pastry = query.getSingleResult();
        return Optional.of(pastry);
    }

    @Override
    public Optional<Pastry> get(Long id) {
        Pastry pastry = em.find(Pastry.class, id);
        return Optional.ofNullable(pastry);
    }

    @Override
    public List<Pastry> getAll() {
        List<Pastry> pastries = em.createQuery("FROM Pastry", Pastry.class).getResultList();
        return pastries;
    }

    @Override
    public void save(Pastry pastry) {
        try {
            startTransaction();
            em.persist(pastry);
            endTransaction();
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
            rollback();
        }
    }

    @Override
    public void update(Pastry pastry) {
        try {
        startTransaction();
        em.merge(pastry);
        endTransaction();
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
            rollback();
        }
    }

    @Override
    public void delete(Pastry pastry) {
        try {
            startTransaction();
            em.remove(em.contains(pastry) ? pastry : em.merge(pastry));
            endTransaction();
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
            rollback();
        }
    }
}