package com.smi.innothink.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Batch;

public interface BatchRepository extends JpaRepository<Batch, String>{
	@Procedure(name = "in_and_out_test_batch")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);

	@Query("from Batch")
     ArrayList<Batch> getBatch();


}
