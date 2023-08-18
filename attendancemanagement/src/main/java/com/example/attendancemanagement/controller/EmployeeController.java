package com.example.attendancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendancemanagement.dto.EmployeeDTO;
import com.example.attendancemanagement.service.EmployeeService;

@RestController

public class EmployeeController {

     private final EmployeeService employeeService;

    @Autowired 
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployeeDataWithAttendance() {
        return employeeService.getAllEmployeeDataWithAttendance();
    }
    
}
