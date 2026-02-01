package com.example.demo.controller;

import com.example.demo.dto.BankDto;
import com.example.demo.dto.CreateBankDto;
import com.example.demo.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    /**
     * Create a new bank
     * Endpoint: POST /api/banks
     * Body: CreateBankDto
     * Returns: BankDto with 201 status
     */
    @PostMapping
    public ResponseEntity<BankDto> createBank(@RequestBody CreateBankDto createBankDto) {
        BankDto bankDto = bankService.createBank(createBankDto);
        return new ResponseEntity<>(bankDto, HttpStatus.CREATED);
    }

    /**
     * Get bank by ID
     * Endpoint: GET /api/banks/{bankId}
     * Returns: BankDto
     */
    @GetMapping("/{bankId}")
    public ResponseEntity<BankDto> getBank(@PathVariable Long bankId) {
        BankDto bankDto = bankService.getBankById(bankId);
        return ResponseEntity.ok(bankDto);
    }
}
