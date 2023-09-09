package com.example.attendancemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendancemanagement.entity.EmployeeAttendance;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance ,Long >{

    List<EmployeeAttendance> findByEmpid(Long empid);
    List<EmployeeAttendance> findByDate(String date);
    List<EmployeeAttendance> findByEmpidAndDate(Long empid,String date);

    List<EmployeeAttendance> findByDateBetween(String startDate, String endDate);

   List<EmployeeAttendance>  findByEmpidAndDateBetween(Long empid , String startDate, String endDate);
}
