package com.na.project.todolist.dao;

import com.na.project.todolist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepo extends JpaRepository<Item, Integer> {


}
