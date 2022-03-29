package com.iremgunay.springdataexample.controller;

import com.iremgunay.springdataexample.entity.Customer;
import com.iremgunay.springdataexample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    List<Customer> customers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    Customer byId(@PathVariable long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @PostMapping
    Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/{customer}")
    void delete(@PathVariable Customer customer) {
        customerRepository.delete(customer);
    }

    @GetMapping("/search")
    List<Customer> searchByAge(@RequestParam int age) {
        return customerRepository.findByAge(age);
    }
}
