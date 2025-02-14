package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Employeerequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @JsonProperty("Emp_Name")
    @NotBlank(message="name is required")
    private String employeeName;

    @JsonProperty("Emp_Position")
    private String position;
    @JsonProperty("Emp_Age")
    private int age;
    @JsonProperty("Emp_YOE")
    private int yearOfExperience;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public Employeerequest() {
    }
}
