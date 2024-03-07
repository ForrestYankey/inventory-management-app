package com.techelevator.controller;

import com.techelevator.dao.InventoryDao;
import com.techelevator.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class InventoryController {

    private InventoryDao inventoryDao;

    @Autowired
    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @GetMapping("/inventory")
    public List<InventoryItem> fetchInventoryItems() {
        List<InventoryItem> inventoryItems = new ArrayList<>();
        inventoryItems = inventoryDao.fetchInventoryItems();
        return inventoryItems;
    }

    @RequestMapping(path = "/inventory/add", method = RequestMethod.POST)
    public InventoryItem addNewInventoryItem(@RequestBody InventoryItem newItem) {
       InventoryItem newInventoryItem = new InventoryItem();
        newInventoryItem = inventoryDao.addNewInventoryItem(newItem);
        return newInventoryItem;
    }
}
