package com.example.demo.controller;

import com.example.demo.model.BankAccount;
import com.example.demo.model.Status;
import com.example.demo.model.Transaction;
import com.example.demo.request.TransactionRequest;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final AccountService accountService;
    private final TransactionService transactionService;
    @GetMapping("/{id}")
    public List<Transaction> getAccountTransactions(@PathVariable Long id){
        BankAccount account = accountService.findById(id);
        return account.getTransactions();
    }

    @PutMapping("/deposit")
    public Status deposit(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.deposit(transactionRequest.getToId(), transactionRequest.getAmount());
    }

    @PutMapping("/withdraw")
    public Status withdraw(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.withdraw(transactionRequest.getFromId(), transactionRequest.getPinCode(), transactionRequest.getAmount());
    }

    @PutMapping("/transfer")
    public Status transfer(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.transfer(transactionRequest.getFromId(), transactionRequest.getToId(), transactionRequest.getPinCode(), transactionRequest.getAmount());
    }
}
