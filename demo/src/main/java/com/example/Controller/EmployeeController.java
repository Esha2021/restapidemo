package com.example.Controller;

import com.example.Entity.EmployeeDetail;
import com.example.Service.EmployeedetailService;
import com.example.request.Employeerequest;
import com.example.request.UpdateEmployeeRequest;
import com.example.response.EmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employeedetail/")
public class EmployeeController {

    @Autowired
    EmployeedetailService employeedetailService;

    @GetMapping("/get")//Retrive the data from Entity EmployeeDetail class.
    public List<EmployeeDetail> getAllEmployee(){
return employeedetailService.getAllEmployee();
    }

    @GetMapping("/getresponse")
    public List<EmployeeResponse> getAllEmployeeResponse(){
        List<EmployeeDetail> employees=employeedetailService.getAllEmployee();
        List <EmployeeResponse> employeeResponseList=new ArrayList<>();

        for (EmployeeDetail emp : employees) {
            EmployeeResponse response = new EmployeeResponse(emp);
            System.out.println(emp.toString());
            employeeResponseList.add(response);
        }

        System.out.println(employeeResponseList.size());
        return employeeResponseList;
    }

    @PostMapping("/create")
    public void postEmployee(@RequestBody EmployeeDetail employeeDetail){
        employeedetailService.addEmployee(employeeDetail);
    }

    @PostMapping("/createrequest")
    public EmployeeResponse createEmplyoee( @Valid  @RequestBody Employeerequest employeerequest){
      EmployeeDetail employeedetail=employeedetailService.createEmployee(employeerequest);
      return new EmployeeResponse(employeedetail);
    }

    @PutMapping("/updaterequest")
public EmployeeResponse updateEmployee( @Valid @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
EmployeeDetail  employeedetail=employeedetailService.UpdateEmployee(updateEmployeeRequest);
        return new EmployeeResponse(employeedetail);
    }

    @DeleteMapping("/delete")
    public  String deleteemployee( @RequestParam long id){
        return employeedetailService.deleteEmployeeById(id);
    }
    @DeleteMapping("/delete/{Id}")
    public String deleteEmployee(@PathVariable long id){
        return employeedetailService.deleteEmployeeById(id);

    }

    @GetMapping("/getByemployeeName/{employeeName}")
    public List<EmployeeResponse> getEmployeeName(@PathVariable String employeeName) {
        List<EmployeeDetail> employeedetail = employeedetailService.getemployeeName(employeeName);
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

                for (EmployeeDetail emp : employeedetail) {
                EmployeeResponse response = new EmployeeResponse(emp);
                System.out.println(emp.toString());
                employeeResponseList.add(response);
            }
        return employeeResponseList;

    }

    @GetMapping("/getByemployeeNameAndAge/{employeeName}/{age}")
    public EmployeeResponse getEmployeeNameAndAge(@PathVariable String employeeName,@PathVariable int age){

        return new EmployeeResponse(employeedetailService.getEmployeeNameAndAge(employeeName,age));
    }

}
