package com.lilyjordan.moochallenge.controller;

/**
 * Created by Lily on 30/06/2019.
 **/

import com.lilyjordan.moochallenge.entity.Customer;
import com.lilyjordan.moochallenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value="/{surname}")
    @ResponseBody
    public Customer getCustomerBySurname(@PathVariable String surname){
        return customerRepository.findBySurname(surname);
    }

}

