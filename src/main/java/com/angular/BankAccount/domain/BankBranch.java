package com.angular.BankAccount.domain;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by Nagendra on 23-10-2016.
 */
@Entity("Branch")
public class BankBranch {
    @Embedded
    private List<BankAccount> bankAccount;
    private String address;
    private Integer pincode;
    @DBRef
    private List<Customer> customers;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<BankAccount> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccount> bankAccount) {
        this.bankAccount = bankAccount;
    }
}
