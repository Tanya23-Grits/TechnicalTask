package com.example.demo.service;

import com.example.demo.model.BankAccount;

import java.util.List;

public interface AccountService {
    List<BankAccount> findAll();

    BankAccount findById(Long id);

    Long createNewAccount(String ownerName, String pinCode);
}
