package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ownerName;
    private String pinCode;
    private Double currentBalance;
    @OneToMany
    private List<Transaction> transactions;

    public BankAccount() {
        ownerName = "defaultName";
        pinCode = "1111";
        currentBalance = 0.0;
        transactions = new ArrayList<>();
    }

    public BankAccount(String ownerName, String pinCode) {
        this.ownerName = ownerName;
        this.pinCode = pinCode;
        currentBalance = 0.0;
        transactions = new ArrayList<>();
    }
}
