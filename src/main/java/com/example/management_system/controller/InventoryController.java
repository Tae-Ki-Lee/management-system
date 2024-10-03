package com.example.management_system.controller;

import com.example.management_system.model.Inventory;
import com.example.management_system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // 특정 점포의 재고 조회 (GET 요청)
    @GetMapping("/{storeId}")
    public List<Inventory> getInventoryByStore(@PathVariable int storeId) {
        return inventoryService.getInventoryByStore(storeId);
    }

    // 재고 추가 (POST 요청)
    @PostMapping
    public Inventory addInventory(@RequestParam int storeId, @RequestParam String itemName, @RequestParam int quantity, @RequestParam double price) {
        return inventoryService.addInventory(storeId, itemName, quantity, price);
    }

    // 재고 삭제 (DELETE 요청)
    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
    }
}