package com.sapient.dao;

import com.sapient.entity.Customer;
import org.springframework.data.repository.CrudRepository;

// A class that implements this interface will be generated on the fly at the runtime by
// spring data jpa
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
