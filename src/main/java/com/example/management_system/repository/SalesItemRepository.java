package com.example.management_system.repository;

import com.example.management_system.model.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem, Integer> {
    // 필요한 경우 커스텀 메서드도 추가 가능
}