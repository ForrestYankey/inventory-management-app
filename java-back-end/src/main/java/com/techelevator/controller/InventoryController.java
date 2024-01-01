package com.techelevator.controller;

import com.techelevator.dao.InventoryDao;
import com.techelevator.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class InventoryController {

    @Autowired
    private InventoryDao inventoryDao;

    @RequestMapping(path = "/inventory", method = RequestMethod.GET)
    public List<InventoryItem> fetchInventoryItems() {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        inventoryItems = inventoryDao.fetchInventoryItems();
        return inventoryItems;
    }
}
