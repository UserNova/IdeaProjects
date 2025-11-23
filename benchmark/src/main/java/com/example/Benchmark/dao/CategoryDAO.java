package com.example.Benchmark.dao;


import com.example.Benchmark.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CategoryDAO {
    private EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    public List<Category> findAll(int page, int size) {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
        query.setFirstResult((page-1)*size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public void save(Category category) {
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
    }

    public void update(Category category) {
        em.getTransaction().begin();
        em.merge(category);
        em.getTransaction().commit();
    }

    public void delete(Category category) {
        em.getTransaction().begin();
        em.remove(category);
        em.getTransaction().commit();
    }
}
