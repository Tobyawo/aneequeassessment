//package com.awoyomi.aneequeassessment.repository;
//
//import com.awoyomi.aneequeassessment.model.Customer;
//import com.awoyomi.aneequeassessment.model.request.SignupRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Map;
//
//@Repository
//public class CustomerRepoImplementation implements CustomerRepo {
//    private RedisTemplate<String, Customer> redisTemplate;
//    private HashOperations hashOperations; //to access redis cache
//
//    public CustomerRepoImplementation(RedisTemplate<String, Customer> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//
//        hashOperations = redisTemplate.opsForHash();
//    }
//    @Override
//    public void save(SignupRequest signupRequest) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Customer newCustomer = objectMapper.convertValue(signupRequest, Customer.class);
//        newCustomer.setCreatedAt(getDate());
//        hashOperations.put("Customer",newCustomer.getId(),newCustomer);
//    }
//
//    @Override
//    public Map<String,Customer> findAll() {
//        return hashOperations.entries("Customer");
//    }
//
//    @Override
//    public Customer findCustomerByEmail(String email) {
//        return (Customer)hashOperations.get("Customer",email);
//    }
//
//    @Override
//    public Customer getCustomerByEmailAndPassword(String email, String password) {
//        return null;
//    }
//
//
//    @Override
//    public void delete(String id) {
//        hashOperations.delete("Customer",id);
//    }
//
//    public String getDate() {
//        LocalDateTime dateTime = LocalDateTime.now();
//        return dateTime.format(DateTimeFormatter.ofPattern("hh:mm a | dd-MMM"));
//    }
//}
