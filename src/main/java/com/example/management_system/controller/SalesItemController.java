package com.example.management_system.controller;

import com.example.management_system.model.SalesItem;
import com.example.management_system.service.SalesItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales_items")
public class SalesItemController {

    @Autowired
    private SalesItemService salesItemService;

    // 모든 판매 아이템 조회 (GET 요청)
    @GetMapping
    public List<SalesItem> getAllSalesItems() {
        return salesItemService.getAllSalesItems();
    }

    // 특정 판매 아이템 추가 (POST 요청)
    @PostMapping
    public SalesItem addSalesItem(@RequestParam String name, @RequestParam double price) {
        return salesItemService.addSalesItem(name, price);
    }

    // 특정 판매 아이템 삭제 (DELETE 요청)
    @DeleteMapping("/{id}")
    public void deleteSalesItem(@PathVariable int id) {
        salesItemService.deleteSalesItem(id);
    }
}