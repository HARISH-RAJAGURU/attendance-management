package com.example.attendancemanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.example.attendancemanagement.dto.EmployeeAuthDTO;
import com.example.attendancemanagement.entity.userAuthentication;
import com.example.attendancemanagement.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendancemanagement.dto.EmployeeDTO;
import com.example.attendancemanagement.entity.EmployeeAttendance;
import com.example.attendancemanagement.entity.EmployeeData;
import com.example.attendancemanagement.repository.EmployeeAttendanceRepository;
import com.example.attendancemanagement.repository.EmployeeDataRepository;

@Service
public class EmployeeService {

    @Autowired
    private  EmployeeAttendanceRepository employeeAttendanceRepository;
    @Autowired
    private  EmployeeDataRepository employeeDataRepository;
    @Autowired
    private AuthenticationRepository authenticationRepository;



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

    public List<EmployeeAuthDTO> getDataWithAuthentication(){
        List<EmployeeAuthDTO> result= new ArrayList<>();
        List<userAuthentication> users = authenticationRepository.findAll();

        for(userAuthentication user : users){
            Long employeeId  = user.getEmpid();
            EmployeeData data = employeeDataRepository.findById(employeeId).orElse(null);

            if(data != null){
                EmployeeAuthDTO dto = new EmployeeAuthDTO(user , data);
                result.add(dto);
            }
        }

        return result;

    }
    
}
