package com.lilyjordan.moochallenge.init;

import com.lilyjordan.moochallenge.entity.Customer;
import com.lilyjordan.moochallenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Lily on 30/06/2019.
 **/

@Component
public class DataInit implements ApplicationRunner {

    private CustomerRepository customerRepository;

    @Autowired
    public DataInit(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer bobSmith = new Customer();
        bobSmith.setFirstName("Bob");
        bobSmith.setSurname("Smith");
        bobSmith.setPhoneNumber("+447123456789");
        bobSmith.setEmailAddress("bob@bobsmith.com");
        bobSmith.setPostalAddress("5 Drury Lane");

        customerRepository.save(bobSmith);
    }
}