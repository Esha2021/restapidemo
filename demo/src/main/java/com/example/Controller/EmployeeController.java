package com.example.Controller;

import com.example.Entity.EmployeeDetail;
import com.example.Service.EmployeedetailService;
import com.example.request.Employeerequest;
import com.example.request.UpdateEmployeeRequest;
import com.example.response.EmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/getYOEOrAge/{yearOfExperience}/{age}")
    public List<EmployeeResponse> getYearOfExperienceOrAge( @ PathVariable int yearOfExperience,@PathVariable int age){
        List<EmployeeDetail> employeedetail=employeedetailService.getYearOfExperienceOrAge(yearOfExperience,age);

        List<EmployeeResponse> employeeResponseList=new ArrayList<EmployeeResponse>();
        for(EmployeeDetail emp1:employeedetail) {
            EmployeeResponse response = new EmployeeResponse(emp1);

            employeeResponseList.add(response);
        }
        return employeeResponseList;

    }
    @GetMapping("getEmployeeNameIn/{employeeName}")
public List<EmployeeResponse> getEmployeeNameIn(@PathVariable List<String> employeeName){
        return employeedetailService.getEmployeeNameIn(employeeName)
                .stream()
                .map(EmployeeResponse::new)
                .collect(Collectors.toList());

    }
    @GetMapping("/getPagination")
public List<EmployeeResponse> getPagination(@RequestParam int pageNo,@RequestParam int pageSize){
    return employeedetailService.getPagination(pageNo, pageSize)
            .stream()
            .map(EmployeeResponse::new)
            .collect(Collectors.toList());
}

    @GetMapping("/getSorting")
    public List<EmployeeResponse> getSorting(){
        return employeedetailService.getSorting()
                .stream()
                .map(EmployeeResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/getlike/{employeeName}")
    public List<EmployeeResponse> getFindByContains(@PathVariable String employeeName){
        List<EmployeeDetail> employeedetail=employeedetailService.getfirstnameContains(employeeName);

        List<EmployeeResponse> employeeResponseList=new ArrayList<EmployeeResponse>();
        for(EmployeeDetail emp1:employeedetail) {
            EmployeeResponse response = new EmployeeResponse(emp1);

            employeeResponseList.add(response);
        }
        return employeeResponseList;
    }
    @GetMapping("/getprefix/{employeeName}")
    public List<EmployeeResponse> getFindByStartingWith(@PathVariable String employeeName){
        List<EmployeeDetail> employeedetail=employeedetailService.getfirstnameStartingWith(employeeName);

        List<EmployeeResponse> employeeResponseList=new ArrayList<EmployeeResponse>();
        for(EmployeeDetail emp1:employeedetail) {
            EmployeeResponse response = new EmployeeResponse(emp1);

            employeeResponseList.add(response);
        }
        return employeeResponseList;
    }
    @GetMapping("/getsuffix/{employeeName}")
    public List<EmployeeResponse> getFindByEndingWith(@PathVariable String employeeName){
        List<EmployeeDetail> employeedetail=employeedetailService.getfirstnameEndingWith(employeeName);

        List<EmployeeResponse> employeeResponseList=new ArrayList<EmployeeResponse>();
        for(EmployeeDetail emp1:employeedetail) {
            EmployeeResponse response = new EmployeeResponse(emp1);

            employeeResponseList.add(response);
        }
        return employeeResponseList;
    }

    //JPQL cocepts
  @GetMapping("/getJPQL/{employeeName}/{age}")
    public EmployeeResponse getEmployeeNameAndAgeJPQL(@PathVariable("employeeName") String employeeName,@PathVariable("age") int age){

        return new EmployeeResponse(employeedetailService.getEmployeeNameAndAgeJPQL(employeeName,age));
    }



}


