package com.example.attendancemanagement.repository;

import com.example.attendancemanagement.entity.userAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<userAuthentication, Long> {

    userAuthentication findByEmailAndPassword(String email , String password);
}
