package com.example.attendancemanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name="employeeData")

public class EmployeeData {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Date_of_birth")
    private String dob;

    @Column(name = "Company")
    private String company;
    
}
