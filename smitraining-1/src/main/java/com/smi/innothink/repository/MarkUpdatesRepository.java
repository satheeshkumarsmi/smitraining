package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.MarkUpdates;

public interface MarkUpdatesRepository extends JpaRepository<MarkUpdates, String>{
	@Procedure(name = "in_and_out_test_markupdates")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
}
