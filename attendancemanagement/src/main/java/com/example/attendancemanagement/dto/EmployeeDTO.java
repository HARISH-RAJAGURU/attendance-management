package com.example.attendancemanagement.dto;

import com.example.attendancemanagement.entity.EmployeeAttendance;
import com.example.attendancemanagement.entity.EmployeeData;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmployeeDTO {
    private Long id;
    private String name;
    private String dob;
    private String company;
    private String date;

    public EmployeeDTO(EmployeeAttendance attendance, EmployeeData data) {
        this.id = data.getId();
        this.name = data.getName();
        this.dob = data.getDob();
        this.company = data.getCompany();
        this.date = attendance.getDate();
    }
}
