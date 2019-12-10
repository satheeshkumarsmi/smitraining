package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.StudentPersonal;

public interface StudentPersonalRepository extends JpaRepository<StudentPersonal, Integer> {

	@Procedure(name = "in_and_out_test_studentpersonal")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
  // @Query("select studentPersonalId from StudentPersonal where studentMobile LIKE ':mobile%'")
  // Iterable getPersonalIdByMobile(@Param ("mobile")String mobile);
}
