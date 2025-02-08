package com.example.Service;

import com.example.Entity.EmployeeDetail;
import com.example.Repository.EmployeeRepository;
import com.example.request.Employeerequest;
import com.example.request.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class EmployeedetailService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDetail> getAllEmployee(){
       return employeeRepository.findAll();
    }

    public EmployeeDetail addEmployee(@RequestBody EmployeeDetail employeeDetail){
        return employeeRepository.save(employeeDetail);
    }

    public EmployeeDetail createEmployee(Employeerequest employeerequest){
        EmployeeDetail employeeDetail=new EmployeeDetail(employeerequest);//employeeerequest object is mapped into the employy detail class
        employeeDetail =employeeRepository.save(employeeDetail); //employee detail is added into the repository
return employeeDetail;//
    }


    public EmployeeDetail UpdateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        EmployeeDetail employeeDetail=employeeRepository.findById(updateEmployeeRequest.getEmployeeId()).get();

        if(  updateEmployeeRequest.getEmployeeName()!=null && !updateEmployeeRequest.getEmployeeName().isEmpty()){
            employeeDetail.setEmployeeName(updateEmployeeRequest.getEmployeeName());
        }
        if(  updateEmployeeRequest.getPosition()!=null && !updateEmployeeRequest.getPosition().isEmpty()){
            employeeDetail.setPosition(updateEmployeeRequest.getPosition());
        }
        employeeDetail= employeeRepository.save(employeeDetail);
        return  employeeDetail;
    }

   public String deleteEmployeeById(long id){
        employeeRepository.deleteById(id);
        return "sucessfully deleted";
    }

    public List<EmployeeDetail> getemployeeName( String employeeName){

        return employeeRepository.findByemployeeName(employeeName);
    }
    public EmployeeDetail getEmployeeNameAndAge( String employeeName,int age){

        return employeeRepository.findByemployeeNameAndAge(employeeName,age);
    }
    public List<EmployeeDetail> getYearOfExperienceOrAge(int yearOfExperience,  int age) {

        return employeeRepository.findByyearOfExperienceOrAge( yearOfExperience,age);


    }

    public List<EmployeeDetail> getEmployeeNameIn( List<String> employeeName){

        return employeeRepository.findByEmployeeNameIn(employeeName);

    }

    public List<EmployeeDetail> getPagination(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return employeeRepository.findAll(pageable).getContent();
    }
    public List<EmployeeDetail> getSorting(){
       Sort sort= Sort.by(Sort.Direction.ASC,"employeeName");
        return  employeeRepository.findAll(sort);
    }

    }