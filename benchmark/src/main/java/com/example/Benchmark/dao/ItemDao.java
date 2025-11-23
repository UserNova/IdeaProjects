package com.example.Benchmark.dao;


import com.example.Benchmark.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ItemDAO {
    private EntityManager em;

    public ItemDAO(EntityManager em) {
        this.em = em;
    }

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll(int page, int size) {
        TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i", Item.class);
        query.setFirstResult((page-1)*size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public List<Item> findByCategoryId(Long categoryId, int page, int size) {
        TypedQuery<Item> query = em.createQuery(
                "SELECT i FROM Item i WHERE i.category.id = :cid", Item.class);
        query.setParameter("cid", categoryId);
        query.setFirstResult((page-1)*size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public void save(Item item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void update(Item item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public void delete(Item item) {
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }
}
