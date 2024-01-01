package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.InventoryItem;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryDao implements InventoryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public InventoryItem addNewInventoryItem() {
        return null;
    }

    @Override
    public List<InventoryItem> fetchInventoryItems() {
        List<InventoryItem> inventoryItems = new ArrayList<>();

        String sql = "SELECT item_id, name, description, quantity, price FROM inventory";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                inventoryItems.add(mapRowToInventoryItem(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

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
        InventoryItem item = new InventoryItem();
        item.setID(rowSet.getInt("item_id"));
        item.setName(rowSet.getString("name"));
        item.setDescription(rowSet.getString("description"));
        item.setQuantity(rowSet.getInt("quantity"));
        item.setPrice(rowSet.getDouble("price"));
        return item;
    }
}
