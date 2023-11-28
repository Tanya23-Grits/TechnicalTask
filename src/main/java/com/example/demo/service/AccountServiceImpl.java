package com.example.demo.service;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.BankAccount;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    @Override
    public List<BankAccount> findAll() {
        return repository.findAll();
    }

    @Override
    public BankAccount findById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Long createNewAccount(String ownerName, String pinCode) {
        BankAccount account = new BankAccount(ownerName, pinCode);
        return repository.save(account).getId();
    }
}
