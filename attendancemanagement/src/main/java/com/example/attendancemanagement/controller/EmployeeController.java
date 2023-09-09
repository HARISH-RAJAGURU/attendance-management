package com.example.attendancemanagement.controller;

import java.util.List;

import com.example.attendancemanagement.dto.EmployeeAuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendancemanagement.dto.EmployeeDTO;
import com.example.attendancemanagement.service.EmployeeService;

@RestController

public class EmployeeController {

    @Autowired
     private EmployeeService employeeService;



    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployeeDataWithAttendance() {
        return employeeService.getAllEmployeeDataWithAttendance();
    }

    @GetMapping("/all-data-auth")
    public List<EmployeeAuthDTO> getDataWithAuthentication(){
        return employeeService.getDataWithAuthentication();
    }
    
}
