package com.smi.innothink.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Student;
import com.smi.innothink.domain.Trainers;

public interface TrainerRepository extends JpaRepository<Trainers, String>{

	@Procedure(name = "in_and_out_test_trainer")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("inParam2") String inParam2);

	Optional<Trainers> findBytrainerName(String Username);
	
	@Query("select t.mobile from Trainers t where t.trainerId=:id and t.trainerPassword=:password")
	String checkCredential(@Param ("id") String userName,@Param ("password") String password);

	@Query(" select t.trainerId,t.trainerName from Trainers t where trainerId=:id")
	ArrayList<String> getTrainer(@Param ("id") String userName);

}
