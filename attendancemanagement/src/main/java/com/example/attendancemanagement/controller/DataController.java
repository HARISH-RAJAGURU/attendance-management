package com.example.attendancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.attendancemanagement.entity.EmployeeData;
import com.example.attendancemanagement.repository.EmployeeDataRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DataController {

    @Autowired
    private EmployeeDataRepository datarepo;


    @GetMapping("/data")
    public List<EmployeeData> getall() {
        List<EmployeeData> employeeData = datarepo.findAll();
        for(EmployeeData data:employeeData){
            System.out.println(data);
        }
        return employeeData;
    }

    @PostMapping("/post-data")

    public EmployeeData postall(@RequestBody EmployeeData employeeData){
        return datarepo.save(employeeData);
    }

   
}
