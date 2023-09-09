package com.example.attendancemanagement.dto;

import com.example.attendancemanagement.entity.EmployeeAttendance;
import com.example.attendancemanagement.entity.EmployeeData;
import com.example.attendancemanagement.entity.userAuthentication;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeAuthDTO {
    private Long id;
    private String name;
    private String dob;
    private String company;
    private String email;
    private String password;
    private String role;
    public EmployeeAuthDTO(userAuthentication auth, EmployeeData data) {
        this.id = data.getId();
        this.name = data.getName();
        this.dob = data.getDob();
        this.company = data.getCompany();
        this.email = auth.getEmail();
        this.password = auth.getPassword();
        this.role = auth.getRole();

    }
}
