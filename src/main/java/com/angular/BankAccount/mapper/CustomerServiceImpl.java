package com.angular.BankAccount.mapper;

import com.angular.BankAccount.domain.BankAccount;
import com.angular.BankAccount.domain.BankBranch;
import com.angular.BankAccount.domain.Customer;
import com.angular.BankAccount.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nagendra on 23-10-2016.
 */
@Repository
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(String name, Long phoneNumber, String userName,
                                   String password, String email, Long balance){
        if(name == null || userName == null){
            return null;
        }

        Customer byUserName = customerRepository.findByUserName(userName);
        if(byUserName != null){
            return null;
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setUserName(userName);
        customer.setHashedPassword(BCrypt.hashpw(password,BCrypt.gensalt()));
        if(!checkForEmailAlreadyExists(email)) {
            customer.setEmail(email);
        }else {
            return null;
        }
        customer.setBalance(balance);
        customer.setBankBranch(createBankBranch());
        customer.setBankAccounts(Arrays.asList(BankAccount.CURRENT_DEPOSITS, BankAccount.SAVING_BANK));
        return customer;
    }

    private List<BankBranch> createBankBranch() {
        List<BankBranch> bankBranches = new ArrayList<>();
        BankBranch bankBranch = null;

        for (int i=0; i<=2; i++){
            bankBranch = new BankBranch();
            bankBranch.setBankAccount(Arrays.asList(BankAccount.values()));
            bankBranch.setAddress("Bangalore"+i);
            bankBranch.setPincode(560054+i);
            bankBranches.add(bankBranch);
        }

        return bankBranches;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    private boolean checkForEmailAlreadyExists(String email) {
        List<Customer> byEmailId = customerRepository.findByEmail(email);
        return !byEmailId.isEmpty();
    }
}
