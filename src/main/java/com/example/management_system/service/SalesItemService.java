package com.example.management_system.service;

import com.example.management_system.model.SalesItem;
import com.example.management_system.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}