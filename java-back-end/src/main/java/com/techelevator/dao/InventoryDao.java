package com.techelevator.dao;

import com.techelevator.model.InventoryItem;

import java.util.List;

public interface InventoryDao {

    InventoryItem addNewInventoryItem();
    List<InventoryItem> fetchInventoryItems();
    InventoryItem updateInventoryItem();
    boolean deleteInventoryItem();
}
