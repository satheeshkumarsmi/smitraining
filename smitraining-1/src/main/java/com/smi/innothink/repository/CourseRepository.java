package com.smi.innothink.repository;
import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.IdBean;
@Repository
public interface CourseRepository extends CrudRepository<Course,String> {
//	@Transactional
//	@Query("select MAX(CAST(REPLACE(CourseID, 'SMI_IT_CUR_', '') AS UNSIGNED))  FROM Course")
//	public String  getId();
	@Procedure(name = "in_and_out_test")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);

	
}
