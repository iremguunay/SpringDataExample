package com.iremgunay.springdataexample;

import com.iremgunay.springdataexample.entity.Customer;
import com.iremgunay.springdataexample.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner databasePopulator(CustomerRepository repository) {
        return args -> {
            repository.save(new Customer("Irem", 25));
            repository.save(new Customer("Pelin", 30));
            repository.save(new Customer("Ayşe", 27));
        };
    }
}
