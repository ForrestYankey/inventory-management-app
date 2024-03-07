package com.techelevator.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.controller.InventoryController;
import com.techelevator.model.InventoryItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class InventoryControllerTests {

    private MockMvc mockMvc;

    @Mock
    private InventoryDao inventoryDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new InventoryController(inventoryDao)).build();
    }

    @Test
    public void testFetchInventoryItems() throws Exception {
        // Arrange
        // Create mock inventory items
        List<InventoryItem> mockItems = new ArrayList<>();
        mockItems.add(new InventoryItem(1, "Item 1", "Description 1", 10, 19.99));
        mockItems.add(new InventoryItem(2, "Item 2", "Description 2", 20, 29.99));

        // Mocking the behavior of InventoryDao to return the mock inventory items
        when(inventoryDao.fetchInventoryItems()).thenReturn(mockItems);

        // Act & Assert
        mockMvc.perform(get("/inventory"))
                // Assert that the response status is 200 OK
                .andExpect(status().isOk())
                // Assert that the JSON response contains the expected inventory items
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Item 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[0].quantity").value(10))
                .andExpect(jsonPath("$[0].price").value(19.99))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Item 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"))
                .andExpect(jsonPath("$[1].quantity").value(20))
                .andExpect(jsonPath("$[1].price").value(29.99));
    }

    //TODO fix
//    @Test
//    public void testAddNewInventoryItem() throws Exception {
//        // Arrange
//        InventoryItem newItem = new InventoryItem(1, "Test Item", "Test Description", 5, 9.99);
//        InventoryItem addedItem = new InventoryItem(1, "Test Item", "Test Description", 5, 9.99);
//
//        // Mocking the behavior of InventoryDao to return the added inventory item
//        when(inventoryDao.addNewInventoryItem(newItem)).thenReturn(addedItem);
//
//        // Act & Assert
//        mockMvc.perform(post("/inventory/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(newItem)))
//                // Assert that the response status is 200 OK
//                .andExpect(status().isOk())
//                // Assert that the response body matches the added inventory item
//                .andExpect(jsonPath("$.ID").value(1))
//                .andExpect(jsonPath("$.name").value("Test Item"))
//                .andExpect(jsonPath("$.description").value("Test Description"))
//                .andExpect(jsonPath("$.quantity").value(5))
//                .andExpect(jsonPath("$.price").value(9.99));
//    }
}
