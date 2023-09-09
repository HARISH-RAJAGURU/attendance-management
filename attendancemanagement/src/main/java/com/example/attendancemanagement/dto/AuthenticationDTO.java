package com.example.attendancemanagement.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationDTO {

    private String email;
    private String password;

}
