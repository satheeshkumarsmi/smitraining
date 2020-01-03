package com.smi.innothink.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	@Procedure(name = "in_and_out_test_student")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
	@Query("from Student s where s.studentName Like  :name ")
	ArrayList<Student> getName(@Param ("name") String name);
	
	
	@Query("from Student s where s.studentName Like  :name ")
	ArrayList<Student> getName1(@Param ("name") String name);
	
	@Query("from Student s where s.studentId=:id")
	Student getStudent(@Param ("id") String k);
	
	@Query("select s.mailId from Student s where s.studentId=:id")
	public String getMail(@Param("id") String id3);
	
	@Query("select b.batchName,s.studentName,s.dateOfJoining,sd.date,sd.teamName from StatusDetails sd join Student s on sd.studentId =s.studentId join Batch b on sd.batchId=b.batchId where sd.status=:id") 
    public ArrayList getDeployedStudent(@Param ("id") String status);
	
	@Query("select b.batchName,s.studentName,s.dateOfJoining,sd.date,sd.teamName,sd.reason from StatusDetails sd join Student s on sd.studentId =s.studentId join Batch b on sd.batchId=b.batchId where sd.status=:id") 
    public ArrayList getDiscontinuedStudent(@Param ("id") String status);
	@Query("select b.batchName,s.studentName,s.dateOfJoining,sd.date,sd.teamName,sd.reason from StatusDetails sd join Student s on sd.studentId =s.studentId join Batch b on sd.batchId=b.batchId where sd.status=:id") 
    public ArrayList getTerminatedStudent(@Param ("id") String status);
	
	@Query("select b.batchName,s.studentName,s.dateOfJoining from StatusDetails sd join Student s on sd.studentId =s.studentId join Batch b on sd.batchId=b.batchId where sd.status=:id") 
    public ArrayList getIntrainingStudent(@Param ("id") String status);
	
	@Query(" from Student s join StudentPersonal sp on s.studentPersonalId=sp.studentPersonalId join AcademicDetails a on a.studentAcademicId=s.academicId")
	public ArrayList getStudent();
	
	@Query("select s.studentId from Student s where s.studentId=:name and s.studentPassword=:password")
	public String checkCredentials(@Param ("name") String userName,@Param ("password") String password);
	@Transactional
	@Modifying
	@Query("update Student set studentPassword=:password where studentId=:userName")
    void changeOldPassword(String userName, String password);
	@Query("select s.studentId from Student s where mailId=:id")
	String getPassword(@Param("id")String mailId);
}
