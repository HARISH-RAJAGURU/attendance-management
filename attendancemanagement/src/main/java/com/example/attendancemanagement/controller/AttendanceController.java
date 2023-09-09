package com.example.attendancemanagement.controller;

import java.util.List;

import com.example.attendancemanagement.dto.DateRangeDTO;
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


        if(id == -1 && date !=null){
            return attendancerepo.findByDate(date);
        } else if(date !=null){
            return attendancerepo.findByEmpidAndDate(id,date);
        } else{
            return attendancerepo.findByEmpid(id);
        }


    }

    @PostMapping("/attendance-by-date-range")
    public List<EmployeeAttendance> getAttendanceByDateRange(@RequestBody DateRangeDTO dateRangeDTO) {

        String startDate = dateRangeDTO.getStartDate();
        String endDate = dateRangeDTO.getEndDate();


        return attendancerepo.findByDateBetween(startDate, endDate);
    }

    @PostMapping("/attendance-all-by-date-range")
    public List<EmployeeAttendance> getAllAttendanceByDateRange(@RequestBody DateRangeDTO dateRangeDTO) {
        Long id = dateRangeDTO.getId();
        String startDate = dateRangeDTO.getStartDate();
        String endDate = dateRangeDTO.getEndDate();

        if(id ==-1 && startDate!=null && endDate !=null){
            return attendancerepo.findByDateBetween(startDate,endDate);
        }else if(startDate!=null && endDate!=null){
            return attendancerepo.findByEmpidAndDateBetween(id,startDate, endDate);
        }else if(startDate == endDate){
            return attendancerepo.findByDate(startDate);
        }else {
             return attendancerepo.findByEmpid(id);
        }

    }



}
