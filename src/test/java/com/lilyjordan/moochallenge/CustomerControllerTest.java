package com.lilyjordan.moochallenge;

import com.lilyjordan.moochallenge.controller.CustomerController;
import com.lilyjordan.moochallenge.entity.Customer;
import com.lilyjordan.moochallenge.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by Lily on 30/06/2019.
 */
public class CustomerControllerTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerController customerController;
    private Customer bobSmith;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        customerController = new CustomerController(customerRepository);

        bobSmith = new Customer();
        bobSmith.setId(1L);
        bobSmith.setFirstName("Bob");
        bobSmith.setSurname("Smith");
        bobSmith.setPhoneNumber("+447123456789");
        bobSmith.setEmailAddress("bob@bobsmith.com");
        bobSmith.setPostalAddress("5 Drury Lane");
    }

    @Test
    public void testGetCustomerBySurname() throws Exception {
        when(customerRepository.findBySurname("Smith")).thenReturn(bobSmith);
        assertEquals(bobSmith, customerController.getCustomerBySurname("Smith"));
    }

    @Test
    public void testGetCustomerBySurnameDoesntExist() throws Exception {
        when(customerRepository.findBySurname("Jones")).thenReturn(null);
        assertNull(customerController.getCustomerBySurname("Smith"));
    }

}