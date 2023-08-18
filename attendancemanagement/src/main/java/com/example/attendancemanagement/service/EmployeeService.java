package com.example.attendancemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendancemanagement.dto.EmployeeDTO;
import com.example.attendancemanagement.entity.EmployeeAttendance;
import com.example.attendancemanagement.entity.EmployeeData;
import com.example.attendancemanagement.repository.EmployeeAttendanceRepository;
import com.example.attendancemanagement.repository.EmployeeDataRepository;

@Service
public class EmployeeService {

    private final EmployeeAttendanceRepository employeeAttendanceRepository;
    private final EmployeeDataRepository employeeDataRepository;

    @Autowired
    public EmployeeService(EmployeeAttendanceRepository employeeAttendanceRepository,
                           EmployeeDataRepository employeeDataRepository) {
        this.employeeAttendanceRepository = employeeAttendanceRepository;
        this.employeeDataRepository = employeeDataRepository;
    }

    public List<EmployeeDTO> getAllEmployeeDataWithAttendance() {
        List<EmployeeDTO> result = new ArrayList<>();
        List<EmployeeAttendance> attendances = employeeAttendanceRepository.findAll();

        for (EmployeeAttendance attendance : attendances) {
            Long employeeId = attendance.getEmpid();
            EmployeeData data = employeeDataRepository.findById(employeeId).orElse(null);

            if (data != null) {
                EmployeeDTO dto = new EmployeeDTO(attendance, data);
                result.add(dto);
            }
        }
        return result;
    }
    
}
