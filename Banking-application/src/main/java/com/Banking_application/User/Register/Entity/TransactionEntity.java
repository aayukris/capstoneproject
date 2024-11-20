package com.Banking_application.User.Register.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TransactionId;

    @Column(name = "Username")
    private String username;

    @Column(name = "Amount")
    private Long Amount;

    @Column(name = "Paid To")
    private String PaidTo;

    @Column(name = "TimeStamp")
    private LocalDateTime timestamp;


    @Column(name = "Description")
    private String description;

    @Column(name = "Transaction Type")
    private String transactionType;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Long transactionId) {
        TransactionId = transactionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAmount() {
        return Amount;
    }

    public void setAmount(Long amount) {
        Amount = amount;
    }

    public String getPaidTo() {
        return PaidTo;
    }

    public void setPaidTo(String paidTo) {
        PaidTo = paidTo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}
