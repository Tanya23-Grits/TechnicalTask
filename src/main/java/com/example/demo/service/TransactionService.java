package com.example.demo.service;
import com.example.demo.model.Status;
import com.example.demo.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions(Long accountNumber);
    Status deposit(Long toId, Double amount);

    Status withdraw(Long toId, String pinCode, Double amount);

    Status transfer(Long fromId, Long toId, String pinCode, Double amount);

}
