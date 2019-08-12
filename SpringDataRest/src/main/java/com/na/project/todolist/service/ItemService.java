package com.na.project.todolist.service;

import com.na.project.todolist.dao.ItemRepo;
import com.na.project.todolist.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class ItemService implements IItemService{

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<Item> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public Item findById(int id) {
        return itemRepo.findById(id).get();
    }

    @PreDestroy
    public void onExit() {
        System.out.println("PreDestroy ---- ItemService");
    }
}
