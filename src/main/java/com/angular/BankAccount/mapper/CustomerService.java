package com.angular.BankAccount.mapper;

import com.angular.BankAccount.domain.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by Nagendra on 23-10-2016.
 */
public interface CustomerService {

    Customer createCustomer(String name, Long phoneNumber, String userName,
                            String password, String email, Long balance);

    void saveCustomer(Customer customer);
}
