package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Subject;
public interface SubjectRepository extends JpaRepository<Subject, String>{

	@Procedure(name = "in_and_out_test_subject")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);

	@Query("select s.subjectName s.subjectId from Subject s where s.courseId=:id")
	Iterable<Subject> getSubjects(@Param("id") String courseId);

}
