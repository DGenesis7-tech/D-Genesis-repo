package com.example.demo.service;

import com.example.demo.dto.BankDto;
import com.example.demo.dto.CreateBankDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bank;
import com.example.demo.repository.BankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    /**
     * Create a new bank
     */
    public BankDto createBank(CreateBankDto createBankDto) {
        if (createBankDto.getName() == null || createBankDto.getName().isBlank()) {
            throw new BadRequestException("Bank name is required");
        }
        if (createBankDto.getCode() == null || createBankDto.getCode().isBlank()) {
            throw new BadRequestException("Bank code is required");
        }
        if (createBankDto.getEmail() == null || createBankDto.getAdminEmail().isBlank()) {
            throw new BadRequestException("Admin email is required");
        }

        // Check if bank already exists
        if (bankRepository.findByCode(createBankDto.getCode()).isPresent()) {
            throw new BadRequestException("Bank with code " + createBankDto.getCode() + " already exists");
        }

        Bank bank = new Bank();
        bank.setName(createBankDto.getName());
        bank.setCode(createBankDto.getCode());
        bank.setAdminEmail(createBankDto.getAdminEmail());

        Bank savedBank = bankRepository.save(bank);
        return mapToDto(savedBank);
    }

    /**
     * Get bank by ID
     */
    public BankDto getBankById(Long bankId) {
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found"));
        return mapToDto(bank);
    }

    /**
     * Get bank by code
     */
    public Bank getBankByCode(String code) {
        return bankRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found"));
    }

    /**
     * Convert Bank entity to BankDto
     */
    private BankDto mapToDto(Bank bank) {
        return new BankDto(
                bank.getId(),
                bank.getName(),
                bank.getCode(),
                bank.getAdminEmail(),
                bank.getCreatedAt(),
                bank.getUpdatedAt()
        );
    }
}
