package com.techelevator.dao;

import com.techelevator.model.InventoryItem;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcInventoryDao implements InventoryDao{
    @Override
    public InventoryItem addNewInventoryItem() {
        return null;
    }

    @Override
    public List<InventoryItem> fetchInventoryItems() {
        List<InventoryItem> inventoryItems = null;

        String sql = "SELECT item_id, name, description, quantity, price FROM inventory";

        return inventoryItems;
    }

    @Override
    public InventoryItem updateInventoryItem() {
        return null;
    }

    @Override
    public boolean deleteInventoryItem() {
        return false;
    }

    private InventoryItem mapRowToInventoryItem(SqlRowSet rowSet) {
        InventoryItem item = null;
        item.setID(rowSet.getInt("item_id"));
        item.setName(rowSet.getString("name"));
        item.setDescription(rowSet.getString("description"));
        item.setQuantity(rowSet.getInt("quantity"));
        item.setPrice(rowSet.getDouble("price"));
        return item;
    }
}
