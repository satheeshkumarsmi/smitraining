package com.smi.innothink.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smi.innothink.domain.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course,String> {

	@Procedure(name = "in_and_out_test")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);

		@Query("select C.courseID from Course C where C.course_name= :course_name")
		String  getCourseId(@Param("course_name") String course_name);
}
