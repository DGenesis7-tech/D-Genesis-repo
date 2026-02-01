package com.example.demo.repository;

import com.example.demo.model.AirtimePurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AirtimePurchaseRepository extends JpaRepository<AirtimePurchase, Long> {
    List<AirtimePurchase> findByUserId(Long userId);
    List<AirtimePurchase> findByPhoneNumber(String phoneNumber);
}
