package com.example.Repository;

import com.example.Entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetail,Long> {

    List<EmployeeDetail> findByemployeeName(String employeeName);

    EmployeeDetail findByemployeeNameAndAge(String employeeName,int age);

    List<EmployeeDetail> findByyearOfExperienceOrAge(int yearOfExperience,int age);

    List <EmployeeDetail> findByEmployeeNameIn(List<String> employeeName);

    List <EmployeeDetail> findByEmployeeNameContaining(String EmployeeName);

    List <EmployeeDetail> findByEmployeeNameStartingWith(String EmployeeName);
    List <EmployeeDetail> findByEmployeeNameEndingWith(String EmployeeName);

    //JPQL concepts
    @Query("From EmployeeDetail where employeeName=:employeeName and age=:age ")
    EmployeeDetail getemployeeNameAndAgeJPQL(@Param("employeeName") String employeeName, @Param("age") int age);

}
