package com.example.attendancemanagement.controller;

import com.example.attendancemanagement.dto.AuthenticationDTO;
import com.example.attendancemanagement.entity.EmployeeData;
import com.example.attendancemanagement.entity.userAuthentication;
import com.example.attendancemanagement.repository.AuthenticationRepository;
import com.example.attendancemanagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationRepository authenticationRepo;

    @Autowired
    private AuthenticationService authenticationService;

//    @Autowired
//    public AuthenticationController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }


    @GetMapping("/all-auth")
    public List<userAuthentication> getAllCredentials() {
        List<userAuthentication> allCredentials = authenticationRepo.findAll();
        for (userAuthentication credentials : allCredentials) {
            System.out.println(credentials);
        }
        return allCredentials;
    }

    @PostMapping("/post-credential")

    public userAuthentication postCredential(@RequestBody userAuthentication userAuth) {
        return authenticationRepo.save(userAuth);
    }

    @PostMapping("/post-all-credentials")

    public List<userAuthentication> postAllCredentials(@RequestBody List<userAuthentication> userAuthentications) {
        return authenticationRepo.saveAll(userAuthentications);
    }

    @PostMapping("/check-authentication")
    public boolean checkAuthentication(@RequestBody AuthenticationDTO authDto) {
        return authenticationService.checkAuthentication(authDto);
    }

}
