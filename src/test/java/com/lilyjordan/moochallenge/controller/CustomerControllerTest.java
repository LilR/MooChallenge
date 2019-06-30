package com.lilyjordan.moochallenge.controller;

import com.lilyjordan.moochallenge.entity.Customer;
import com.lilyjordan.moochallenge.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Lily on 30/06/2019.
 */
public class CustomerControllerTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerController customerController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        customerController = new CustomerController(customerRepository);
    }

    @Test
    public void testGetCustomerBySurname() throws Exception {
        Customer bobSmith = new Customer();
        bobSmith.setFirstName("Bob");
        bobSmith.setSurname("Smith");
        bobSmith.setPhoneNumber("+447123456789");
        bobSmith.setEmailAddress("bob@bobsmith.com");
        bobSmith.setPostalAddress("5 Drury Lane");

        when(customerRepository.findBySurname("Smith")).thenReturn(bobSmith);
        assertEquals(bobSmith, customerController.getCustomerBySurname("Smith"));
    }
}