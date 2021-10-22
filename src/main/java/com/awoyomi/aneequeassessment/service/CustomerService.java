package com.awoyomi.aneequeassessment.service;

import com.awoyomi.aneequeassessment.model.Customer;
import com.awoyomi.aneequeassessment.model.request.SignupRequest;
import com.awoyomi.aneequeassessment.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    public Customer addCustomer(SignupRequest signupRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer newCustomer = objectMapper.convertValue(signupRequest, Customer.class);
        newCustomer.setCreatedAt(getDate());
        return customerRepository.save(newCustomer);
    }

    public Customer getCustomerByEmailAndPassword(String email, String password) {
        return customerRepository.getCustomerByEmailAndPassword(email, password);
    }
    public Customer getCustomerById(Long customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    public List<Customer> AllCustomer() {
        return customerRepository.findAll();
    }

    public Page<Customer> getAllCustomer(Pageable page) {
        return customerRepository.findAll(page);
    }



    public String getDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ofPattern("hh:mm a | dd-MMM"));
    }


}
