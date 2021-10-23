package com.awoyomi.aneequeassessment.controller;

import com.awoyomi.aneequeassessment.model.Customer;
import com.awoyomi.aneequeassessment.model.request.LoginRequest;
import com.awoyomi.aneequeassessment.model.request.SignupRequest;
import com.awoyomi.aneequeassessment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


    @GetMapping(path = "/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Customer> loginUser(@RequestBody LoginRequest loginRequest){
        Customer customer = customerService.getCustomerByEmail(loginRequest.getEmail());
        if( customer== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer checkCustomerByEmailandPass = customerService.getCustomerByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (checkCustomerByEmailandPass == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }




    //new user signup
    @PostMapping(path = "/signUp", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Customer> signUpUser( @RequestBody SignupRequest signupRequest){
         Customer newCustomer = customerService.addCustomer(signupRequest);
       return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }



    @GetMapping(path = "/customers", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> listOfCustomer(){
        List<Customer> allCustomers = customerService.AllCustomer();
        return new ResponseEntity< >(allCustomers, HttpStatus.OK);
    }









}