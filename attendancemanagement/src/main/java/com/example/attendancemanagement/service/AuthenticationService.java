package com.example.attendancemanagement.service;

import com.example.attendancemanagement.dto.AuthenticationDTO;
import com.example.attendancemanagement.entity.userAuthentication;
import com.example.attendancemanagement.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authrepo;
    public boolean checkAuthentication(AuthenticationDTO authenticationDTO) {
        userAuthentication user = authrepo.findByEmailAndPassword(
                authenticationDTO.getEmail(),
                authenticationDTO.getPassword()
        );

        return user != null;
    }

}
