package com.sample.microservice.awsdynamodb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

    private String id;

    private String firstName;

    private String lastName;

    private String number;

    private String email;

    private String department;

    private double salary;

}
