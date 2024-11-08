package com.example.management_system.controller;

import com.example.management_system.model.Inventory;
import com.example.management_system.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getallInventory(){
        return inventoryService.getInventory();
    }
    // 특정 점포의 재고 조회 (GET 요청)
    @GetMapping("/{storeId}")
    public List<Inventory> getInventoryByStore(@PathVariable int storeId) {
        return inventoryService.getInventoryByStore(storeId);
    }

    // 재고 추가 (POST 요청)
    @PostMapping("/add")
    public Inventory addInventory(@RequestParam int storeId, @RequestParam String itemName, @RequestParam int quantity, @RequestParam double price) {
        return inventoryService.addInventory(storeId, itemName, quantity, price);
    }

    // 재고 삭제 (DELETE 요청)
    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        Optional<Inventory> tempInventory = inventoryService.getInventoryById(id);
        if (tempInventory.isPresent()) {
            Inventory existingInventory = tempInventory.get();
            existingInventory.setItemName(inventory.getItemName());
            existingInventory.setQuantity(inventory.getQuantity());
            existingInventory.setPrice(inventory.getPrice());

            Inventory updatedInventory = inventoryService.saveInventory(existingInventory);
            return ResponseEntity.ok(updatedInventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}