package com.example.management_system.service;

import com.example.management_system.model.SalesItem;
import com.example.management_system.model.Store;
import com.example.management_system.repository.SalesItemRepository;
import com.example.management_system.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesItemService {

    @Autowired
    private SalesItemRepository salesItemRepository;

    // 모든 판매 아이템 조회
    public List<SalesItem> getAllSalesItems() {
        return salesItemRepository.findAll();
    }

    // 판매 아이템 추가
    public SalesItem addSalesItem(String name, double price) {
        SalesItem salesItem = new SalesItem();
        salesItem.setName(name);
        salesItem.setPrice(price);
        return salesItemRepository.save(salesItem);
    }

    // 판매 아이템 삭제
    public void deleteSalesItem(int id) {
        salesItemRepository.deleteById(id);
    }

    // 판매 아이템 id로 검색 후 리턴
    public Optional<SalesItem> getSalesItembyId(int id){
        return salesItemRepository.findById(id);
    }

    // 판매 아이템 저장
    public SalesItem saveItem(SalesItem item) {
        return salesItemRepository.save(item);
    }
}