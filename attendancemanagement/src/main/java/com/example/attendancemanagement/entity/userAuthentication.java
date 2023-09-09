package com.example.attendancemanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class userAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Employee_Id")
    private Long empid;
    @Column(name = "E-mail")
    private String email;
    @Column(name = "Password")
    private  String password;
    @Column(name="Role")
    private String role;

}
