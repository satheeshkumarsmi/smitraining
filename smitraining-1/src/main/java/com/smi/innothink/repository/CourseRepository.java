package com.smi.innothink.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smi.innothink.domain.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course,String> {
	
	@Query("select max(courseID) from Course")
	String  getId();
}
