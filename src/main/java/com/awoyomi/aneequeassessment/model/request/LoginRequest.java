package com.awoyomi.aneequeassessment.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Column(unique = true, nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;
}