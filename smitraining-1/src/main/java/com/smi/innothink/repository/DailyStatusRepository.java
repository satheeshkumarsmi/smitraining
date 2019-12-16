package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.DailyStatus;

public interface DailyStatusRepository extends CrudRepository<DailyStatus, String> {
	@Procedure(name = "in_and_out_test_dailystatus")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);

}
