package com.smi.innothink.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.MarkUpdates;

public interface MarkUpdatesRepository extends JpaRepository<MarkUpdates, String>{
	@Procedure(name = "in_and_out_test_markupdates")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);

	@Query("select mu.marksObtained ,a.batchId,a.assignDate,a.assesmentType,a.totalMarks, a.status from MarkUpdates mu join AssignAssesment a on a.assignAssesmentId=mu.assignAssesmentId where mu.studentId=:id")
	ArrayList getStudent(@Param ("id") String studentId);
}
