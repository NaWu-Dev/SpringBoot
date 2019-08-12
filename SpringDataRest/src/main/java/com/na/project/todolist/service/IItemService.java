package com.na.project.todolist.service;

import com.na.project.todolist.model.Item;

import java.util.List;

public interface IItemService {

    public List<Item> findAll();
    public Item findById(int id);

}
