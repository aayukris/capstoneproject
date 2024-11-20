package com.Banking_application.User.Register.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 12)
    private Long creditCardId;

    @Column(length = 16, unique = true, nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private Double availableCredit;

    @ManyToOne
    @JoinColumn(name = "credit_id", referencedColumnName = "accountNumber")
    private UserEntity registerEntity;

//    @OneToMany(mappedBy = "creditCardEntity")
//    private List<TransactionEntity> transactions;

    // Getters and Setters
    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
    }

    public UserEntity getRegisterEntity() {
        return registerEntity;
    }

    public void setRegisterEntity(UserEntity registerEntity) {
        this.registerEntity = registerEntity;
    }

//    public List<TransactionEntity> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<TransactionEntity> transactions) {
//        this.transactions = transactions;
//    }
}
