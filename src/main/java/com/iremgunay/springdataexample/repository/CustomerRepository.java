package com.iremgunay.springdataexample.repository;

import com.iremgunay.springdataexample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAge(int age);
}
