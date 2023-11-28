package com.example.demo.request;

public class TransactionRequest {
    private Long fromId;
    private Long toId;
    private String pinCode;
    private double amount;

    public TransactionRequest(Long fromId, Long toId, String pinCode, double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.pinCode = pinCode;
        this.amount = amount;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}