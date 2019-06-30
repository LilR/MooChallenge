package com.lilyjordan.moochallenge.controller;

/**
 * Created by Lily on 30/06/2019.
 */
import com.lilyjordan.moochallenge.entity.Customer;
import com.lilyjordan.moochallenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/{surname}", produces = "application/json")
    public Customer getCustomerBySurname(String surname){
        return customerRepository.findBySurname(surname);
    }

}

