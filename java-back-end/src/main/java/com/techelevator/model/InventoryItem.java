package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.InventoryDao;
import org.springframework.data.relational.core.sql.In;

public class InventoryItem {
    private int ID;
    private String name;
    private String description;
    private int quantity;
    private double price;

    public InventoryItem(){}

    public InventoryItem(int ID, String name, String description, int quantity, double price) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
