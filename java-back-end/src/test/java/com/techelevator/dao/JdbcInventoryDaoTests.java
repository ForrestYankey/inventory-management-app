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
}
