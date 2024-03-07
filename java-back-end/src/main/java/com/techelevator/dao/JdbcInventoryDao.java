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

import static com.techelevator.mappers.InventoryMappers.mapRowToInventoryItem;

@Component
public class JdbcInventoryDao implements InventoryDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public InventoryItem addNewInventoryItem(InventoryItem newItem) {
        InventoryItem returnedItem = new InventoryItem();
        String sql = "INSERT INTO inventory (name, description, quantity, price) VALUES (?, ?, ?, ?) RETURNING item_id";

        try {
            int id = jdbcTemplate.queryForObject(sql, int.class, newItem.getName(), newItem.getDescription(), newItem.getQuantity(), newItem.getPrice());
            newItem.setID(id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return newItem;
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


}
