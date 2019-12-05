package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.BatchStatus;

public interface BatchStatusRepository extends JpaRepository<BatchStatus, String>{

}
