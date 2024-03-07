package com.techelevator.mappers;

import com.techelevator.model.InventoryItem;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class InventoryMappers {

    public static InventoryItem mapRowToInventoryItem(SqlRowSet rowSet) {
        InventoryItem item = new InventoryItem();
        item.setID(rowSet.getInt("item_id"));
        item.setName(rowSet.getString("name"));
        item.setDescription(rowSet.getString("description"));
        item.setQuantity(rowSet.getInt("quantity"));
        item.setPrice(rowSet.getDouble("price"));
        return item;
    }
}
