package com.angular.BankAccount.service;

import com.angular.BankAccount.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Nagendra on 23-10-2016.
 */

public interface CustomerRepository extends MongoRepository<Customer, Long> {

    Customer findByUserName(String userName);

    List<Customer> findByEmail(String email);

    Customer findByEmailAndHashedPassword(String email, String password);
}
