package com.awoyomi.aneequeassessment.repository;

import com.awoyomi.aneequeassessment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByEmail(String email);

    Customer getCustomerByEmailAndPassword(String email, String password);

    Customer getCustomerById(Long userId);

}
