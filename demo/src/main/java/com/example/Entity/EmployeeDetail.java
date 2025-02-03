package com.example.Entity;

import com.example.request.Employeerequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "employees")
public class EmployeeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @JsonProperty("Emp_Name")
    private String employeeName;

    private String position;

    private int age;

    private int yearOfExperience;

    public EmployeeDetail(String employeeName, String position, int age, int year_of_experience) {

        this.employeeName = employeeName;
        this.position = position;
        this.age = age;
        this.yearOfExperience = year_of_experience;
    }

    public EmployeeDetail() {
    }

    public EmployeeDetail(Employeerequest employeerequest){
        this.employeeName = employeerequest.getEmployeeName();
        this.position =employeerequest.getPosition();
        this.age = employeerequest.getAge();
        this.yearOfExperience =employeerequest.getYearOfExperience() ;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

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

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", yearOfExperience=" + yearOfExperience +
                '}';
    }
}

