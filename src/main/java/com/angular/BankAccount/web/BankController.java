package com.angular.BankAccount.web;

import com.angular.BankAccount.domain.Customer;
import com.angular.BankAccount.mapper.CustomerService;
import com.angular.BankAccount.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Nagendra on 23-10-2016.
 */
@Controller
public class BankController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String actionLogin(HttpServletRequest request, Model model){
        List<Customer> byEmail = customerRepository.findByEmail(request.getParameter("email"));
        if(!byEmail.isEmpty()) {
            Customer customer = byEmail.get(0);
            if (BCrypt.checkpw(request.getParameter("password"), customer.getHashedPassword())) {
                model.addAttribute("customer", customer);
                return "redirect:/enterSiteView.html";
            }
        }
        return "redirect:/errorView.html";
    }

    /*@RequestMapping(value = "/register")
    public String actionRegister(){
        return "index";
    }*/


}
