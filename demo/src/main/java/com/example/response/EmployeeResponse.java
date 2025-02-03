package com.example.response;

import com.example.Entity.EmployeeDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class EmployeeResponse {

    //@JsonProperty("Emp_Id")
    private Long employeeId;

    @JsonProperty("Emp_Name")
    private String employeeName;

    @JsonProperty("Emp_Position")
    private String position;

    @JsonProperty("Emp_Age")
    private int age;

     @JsonProperty("Emp_exp")
    private int yearOfExperience;


    public EmployeeResponse(EmployeeDetail employeeDetail) {
        this.employeeId = employeeDetail.getEmployeeId();
        this.employeeName = employeeDetail.getEmployeeName();
        this.position = employeeDetail.getPosition();
        this.age = employeeDetail.getAge();
        this.yearOfExperience = employeeDetail.getYearOfExperience();
    }
}