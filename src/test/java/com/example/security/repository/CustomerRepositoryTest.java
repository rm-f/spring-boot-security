package com.example.security.repository;

import com.example.security.persistence.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CustomerRepositoryTest {

  @Autowired CustomerRepository customerRepository;

  @Test
  void saveAndFindById() {
    Customer customer =
        customerRepository.save(Customer.builder().id("test").password("test").name("개발자").build());
        customerRepository.save(Customer.builder().id("test1").password("test").name("개발자1").build());
        customerRepository.save(Customer.builder().id("test2").password("test").name("개발자2").build());
    log.info("save : {}", customer.toString());
    Customer customerResult = customerRepository.findById(customer.getId());
    log.info("findById : {} ", customerResult.toString());
    log.info("count : {} ", customerRepository.count());
  }
}
