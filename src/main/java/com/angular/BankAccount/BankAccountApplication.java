package com.angular.BankAccount;

import com.angular.BankAccount.domain.Customer;
import com.angular.BankAccount.mapper.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAccountApplication{

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}

}
