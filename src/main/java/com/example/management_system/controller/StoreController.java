package com.example.management_system.controller;

import com.example.management_system.model.Inventory;
import com.example.management_system.model.Store;
import com.example.management_system.service.InventoryService;
import com.example.management_system.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 모든 점포 조회 (GET 요청)
    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    // 점포 추가 (POST 요청)
    @PostMapping
    public Store addStore(@RequestParam String name, @RequestParam String location) {
        return storeService.addStore(name, location);
    }

    // 특정 점포 삭제 (DELETE 요청)
    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
    }

    // 특정 점포 조회 (GET 요청)
    @GetMapping("/{id}")
    public Optional<Store> getStoreById(@PathVariable int id) {
        return storeService.getStoreById(id);
    }

    // 특정 점포 수정 (PUT 요청)
    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable int id, @RequestBody Store store) {
        Optional<Store> tempStore = storeService.getStoreById(id);
        if (tempStore.isPresent()) {
            Store existingStore = tempStore.get();
            existingStore.setName(store.getName());
            existingStore.setLocation(store.getLocation());
            existingStore.setTotalSales(store.getTotalSales());

            Store updatedStore = storeService.saveStore(existingStore);
            return ResponseEntity.ok(updatedStore);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}