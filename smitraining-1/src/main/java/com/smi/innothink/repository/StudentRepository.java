package com.smi.innothink.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	@Procedure(name = "in_and_out_test_student")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
	@Query("from Student s where s.studentMobile Like  :mobile ")
	ArrayList<Student> getName(@Param ("mobile") String mobile); 
	
	@Query("from Student s where s.studentId=:id")
	Student getStudent(@Param ("id") String k);
}
