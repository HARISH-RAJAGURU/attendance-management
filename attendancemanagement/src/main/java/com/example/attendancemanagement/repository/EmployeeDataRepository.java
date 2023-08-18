package com.example.attendancemanagement.repository;


import java.util.List;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// import com.example.attendancemanagement.entity.AllData;
import com.example.attendancemanagement.entity.EmployeeData;


@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData , Long>{


}
