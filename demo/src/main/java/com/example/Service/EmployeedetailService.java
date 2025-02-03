package com.example.Service;

import com.example.Entity.EmployeeDetail;
import com.example.Repository.EmployeeRepository;
import com.example.request.Employeerequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

//   // public void deleteEmployeebById(Long id){
//        employeeRepository.deleteById(id);
//    }


}