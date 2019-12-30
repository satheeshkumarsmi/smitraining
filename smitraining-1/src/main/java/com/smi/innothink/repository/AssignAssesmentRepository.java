package com.smi.innothink.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.AssignAssesment;

public interface AssignAssesmentRepository extends JpaRepository<AssignAssesment, String> {
	@Procedure(name = "in_and_out_test_assesment")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
   
	@Query("select a.batchId from AssignAssesment a where a.status=:assigned ")
	ArrayList<String> getbatchId(@Param("assigned") String status);
	
	@Query("select a.batchId from AssignAssesment a where a.assignAssesmentId=:id ")
	String getbatchIdOnAssignment(@Param("id") String assignAssesmentId);
	
	@Query("select a.totalMarks from AssignAssesment a where a.assignAssesmentId=:id ")
	Double getTotalMarks(@Param("id") String assignAssesmentId);
	
	@Query("select b.batchName from Batch b where b.batchId=:id")
	ArrayList<String> getBatchName(@Param("id") String batchId);
	
    @Query("from AssignAssesment a where a.status=:assigned")
	Iterable<AssignAssesment> getAssigned(@Param("assigned") String status);
    
    @Query("select p.assignAssesmentId, p.assignDate,p.assesmentType,q.batchName,p.totalQuestions,p.totalMarks,p.status from AssignAssesment p join Batch q on p.batchId=q.batchId ")
    public ArrayList getMarks();
    
    @Query("select p.marksObtained,p.totalMarks,q.studentName from MarkUpdates p join Student q on p.studentId=q.studentId where p.assignAssesmentId= :id")
    public ArrayList getStudent(@Param("id") String assesId);
    
	@Transactional
	@Modifying
	@Query("update AssignAssesment set status=:k where assignAssesmentId=:id")
	void updateStatus(@Param("k") String k,@Param("id") String assessmentId);
}
