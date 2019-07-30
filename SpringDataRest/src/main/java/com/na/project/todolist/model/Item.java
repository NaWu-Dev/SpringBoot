package com.na.project.todolist.model;

import com.na.project.todolist.enums.ItemStatusEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Item implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String Status;
    private Date dateCreated;
    private Date dataCompleted;

    @PrePersist
    protected void prePersist() {
        if (this.dateCreated == null) dateCreated = new Date();
        if (this.Status == null || this.Status.isEmpty()) this.setStatus(ItemStatusEnum.NEW.toString());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Status='" + Status + '\'' +
                ", dateCreated=" + dateCreated +
                ", dataCompleted=" + dataCompleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDataCompleted() {
        return dataCompleted;
    }

    public void setDataCompleted(Date dataCompleted) {
        this.dataCompleted = dataCompleted;
    }
}
