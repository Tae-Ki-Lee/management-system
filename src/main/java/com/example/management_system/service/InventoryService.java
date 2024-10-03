package com.example.management_system.service;

import com.example.management_system.model.Inventory;
import com.example.management_system.model.Store;
import com.example.management_system.repository.InventoryRepository;
import com.example.management_system.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    // 특정 점포에 대한 모든 재고 조회
    public List<Inventory> getInventoryByStore(int storeId) {
        Optional<Store> store = storeRepository.findById(storeId);
        if (store.isPresent()) {
            return inventoryRepository.findAll(); // 실제로는 Store에 해당하는 재고만 반환하는 쿼리가 필요할 수 있음
        }
        return null;  // 해당 점포가 없으면 null 반환 (실제 환경에서는 예외 처리)
    }

    // 재고 추가
    public Inventory addInventory(int storeId, String itemName, int quantity, double price) {
        Optional<Store> store = storeRepository.findById(storeId);
        if (store.isPresent()) {
            Inventory inventory = new Inventory();
            inventory.setStore(store.get());
            inventory.setItemName(itemName);
            inventory.setQuantity(quantity);
            inventory.setPrice(price);
            return inventoryRepository.save(inventory);
        }
        return null;  // 해당 점포가 없으면 null 반환 (실제 환경에서는 예외 처리)
    }

    // 재고 삭제
    public void deleteInventory(int id) {
        inventoryRepository.deleteById(id);
    }
}