package com.example.Service;

import com.example.Entity.EmployeeDetail;
import com.example.Repository.EmployeeRepository;
import com.example.request.Employeerequest;
import com.example.request.UpdateEmployeeRequest;
import com.example.response.EmployeeResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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

//   // public void deleteEmployeebById(Long id){
//        employeeRepository.deleteById(id);
//    }


}