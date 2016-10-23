package com.angular.BankAccount.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Nagendra on 23-10-2016.
 */
@Entity("Customer")
public class Customer {

    @Id
    private String id;
    private String name;
    private Long phoneNumber;
    private String userName;
    private String hashedPassword;
    private String email;
    private Long balance;
    @Embedded
    private List<BankBranch> bankBranch;
    @Embedded
    private List<BankAccount> bankAccounts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public List<BankBranch> getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(List<BankBranch> bankBranch) {
        this.bankBranch = bankBranch;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
