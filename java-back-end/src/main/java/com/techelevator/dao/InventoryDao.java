package com.techelevator.dao;

import com.techelevator.model.InventoryItem;

import java.util.List;

public interface InventoryDao {

    InventoryItem addNewInventoryItem(InventoryItem newItem);
    List<InventoryItem> fetchInventoryItems();
    InventoryItem updateInventoryItem();
    boolean deleteInventoryItem();
}
