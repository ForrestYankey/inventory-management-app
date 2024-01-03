package com.techelevator.dao;

import com.techelevator.model.InventoryItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcInventoryDaoTests extends BaseDaoTests{
    private JdbcInventoryDao sut;
    private static final int INVENTORY_ITEMS_TOTAL = 10;
    private static final InventoryItem TEST_ITEM= new InventoryItem(0, "TEST", "TEST", 1, 1);
    private static final int EXPECTED_ID = 11;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcInventoryDao(jdbcTemplate);
    }

    @Test
    public void fetchInventoryItems_returns_items() {
        List<InventoryItem> returnedInventoryItems = sut.fetchInventoryItems();

        Assert.assertEquals(INVENTORY_ITEMS_TOTAL, returnedInventoryItems.size());
    }

    @Test
    public void addNewInventoryItem_adds_new_item() {
        InventoryItem returnedItem = sut.addNewInventoryItem(TEST_ITEM);

        Assert.assertEquals(EXPECTED_ID, TEST_ITEM.getID());
    }
}
