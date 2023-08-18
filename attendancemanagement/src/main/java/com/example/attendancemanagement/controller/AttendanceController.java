package com.example.attendancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.attendancemanagement.dto.EmployeeDTO;
import com.example.attendancemanagement.entity.EmployeeAttendance;
import com.example.attendancemanagement.repository.EmployeeAttendanceRepository;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class AttendanceController {

    @Autowired
    private EmployeeAttendanceRepository attendancerepo;

    @PostMapping("/post-attendance")
    public EmployeeAttendance postAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
        return attendancerepo.save(employeeAttendance);
    }

    @PostMapping("/post-all-attendance")
    public List<EmployeeAttendance> postAllAttendance(@RequestBody List<EmployeeAttendance> employeeAttendances) {
        return attendancerepo.saveAll(employeeAttendances);
    }
    @GetMapping("/attendance")
    public List<EmployeeAttendance> getAll() {

        List<EmployeeAttendance> employeeAttendance = attendancerepo.findAll();

        for (EmployeeAttendance attendance : employeeAttendance) {
            System.out.println(attendance);
        }
        return employeeAttendance;
    }

    @GetMapping("/attendance/{id}")
    public List<EmployeeAttendance> getAttendanceById(@PathVariable("id") Long id) {
        return attendancerepo.findByEmpid(id);

    }

    @PostMapping("/attendance-by-id")
    public List<EmployeeAttendance> getAttendanceById(@RequestBody EmployeeDTO employeeDTO) {
        Long id = employeeDTO.getId();
        return attendancerepo.findByEmpid(id);
    }

    @PostMapping("/attendance-by-date")
    public List<EmployeeAttendance> getAttendanceByDate(@RequestBody EmployeeDTO employeeDTO){
        String date = employeeDTO.getDate();
        return attendancerepo.findByDate(date);
    }

    @PostMapping("/attendance-both")
    public List<EmployeeAttendance> getAttendanceByBothIdandDate(@RequestBody EmployeeDTO employeeDTO){
        Long id = employeeDTO.getId();
        String date = employeeDTO.getDate();

        if(date != null){
            return attendancerepo.findByEmpidAndDate(id,date);
        }else{
            return attendancerepo.findByEmpid(id);
        }
    }




}
