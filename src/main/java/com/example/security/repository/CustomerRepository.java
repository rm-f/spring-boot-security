package com.example.security.repository;

import com.example.security.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByName(final String name);

  Customer findById(final String id);

  Customer findByNo(final Long no);

}
