package com.example.Benchmark.service;

import com.example.Benchmark.dao.ItemDAO;
import com.example.Benchmark.entity.Item;
import java.util.List;

public class ItemService {

    private final ItemDAO dao;

    public ItemService(ItemDAO dao) {
        this.dao = dao;
    }

    public Item getItem(Long id) {
        return dao.findById(id);
    }

    public List<Item> getItems(int page, int size) {
        return dao.findAll(page, size);
    }

    public List<Item> getItemsByCategory(Long categoryId, int page, int size) {
        return dao.findByCategoryId(categoryId, page, size);
    }

    public void createItem(Item item) {
        dao.save(item);
    }

    public void updateItem(Item item) {
        dao.update(item);
    }

    public void deleteItem(Item item) {
        dao.delete(item);
    }
}
