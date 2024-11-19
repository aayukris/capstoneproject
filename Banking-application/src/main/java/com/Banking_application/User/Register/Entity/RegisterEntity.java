package com.Banking_application.User.Register.Entity;


import jakarta.persistence.*;

@Entity
public class RegisterEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(length = 12)
        private String accountNumber;

        @Column(length = 255)
        private String name;

        @Column(length = 255)
        private String accType;

        @Column(length = 255)
        private String creditId;

        @Column(length = 255)
        private String username;

        @Column(length = 255)
        private String phoneNumber;



        // Getters and Setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccType() {
            return accType;
        }

        public void setAccType(String accType) {
            this.accType = accType;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }
    }


