package com.smi.innothink.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.BatchMapping;
import com.smi.innothink.domain.Student;

public interface BatchMappingRepository extends JpaRepository<BatchMapping, Integer> {

	@Query("select b.studentId from BatchMapping b where batchId=:id")
	ArrayList<String> getStudent(@Param ("id") String batchId);
	@Transactional
	@Modifying
	@Query("delete from BatchMapping  where studentId=:id")
	public void remove(@Param("id") String studentId);
	

}
