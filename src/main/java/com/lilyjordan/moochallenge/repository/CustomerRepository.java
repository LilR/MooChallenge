package com.lilyjordan.moochallenge.repository;

/**
 * Created by Lily on 30/06/2019.
 */

import com.lilyjordan.moochallenge.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    Customer findBySurname(String surname);

}
