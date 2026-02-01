package com.example.demo.repository;

import com.example.demo.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findBySenderId(Long senderId);
    List<Transfer> findByRecipientAccountNumber(String recipientAccountNumber);
}
