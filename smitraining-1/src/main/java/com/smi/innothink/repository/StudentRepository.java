package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smi.innothink.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
