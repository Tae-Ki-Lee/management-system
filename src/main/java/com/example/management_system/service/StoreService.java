package com.example.management_system.service;

import com.example.management_system.model.Inventory;
import com.example.management_system.model.Store;
import com.example.management_system.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    // 모든 점포 조회
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    // 특정 점포 추가
    public Store addStore(String name, String location) {
        Store store = new Store();
        store.setName(name);
        store.setLocation(location);
        store.setTotalSales(0);  // 새로운 점포는 초기 매출을 0으로 설정
        return storeRepository.save(store);
    }

    // 특정 점포 삭제
    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }

    // 특정 점포 조회
    public Optional<Store> getStoreById(int id) {
        return storeRepository.findById(id);
    }

    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }
}