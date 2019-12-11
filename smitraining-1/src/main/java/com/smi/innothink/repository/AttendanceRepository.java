package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smi.innothink.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,  String> {

}
