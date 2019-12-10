package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smi.innothink.domain.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
	

}
