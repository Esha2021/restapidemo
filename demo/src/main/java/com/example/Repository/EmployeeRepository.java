package com.example.Repository;

import com.example.Entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetail,Long> {

    List<EmployeeDetail> findByemployeeName(String employeeName);

    EmployeeDetail findByemployeeNameAndAge(String employeeName,int age);

    List<EmployeeDetail> findByyearOfExperienceOrAge(int yearOfExperience,int age);

    List <EmployeeDetail> findByEmployeeNameIn(List<String> employeeName);


}
