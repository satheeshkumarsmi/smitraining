package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Trainers;

public interface TrainerRepository extends JpaRepository<Trainers, String>{

	@Procedure(name = "in_and_out_test_trainer")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("inParam2") String inParam2);

}
