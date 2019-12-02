package com.smi.innothink;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.IdBean;
import com.smi.innothink.repository.CourseRepository;
import com.smi.innothink.repositoryimpl.CourseRepositoryImpl;
import com.smi.innothink.services.AutoIncrement;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/smi")
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	@Autowired(required=false)
	Course course;
	

	@RequestMapping(value = "/insert", method=RequestMethod.POST, produces = "application/json")
	public boolean insert(@RequestBody(required = false) Course course) {
	    String courseId=courseRepository.getId("courseid","SMI_IT_CUR_","Course");
	    String id=AutoIncrement.incrementId(Integer.parseInt(courseId),"SMI_IT_CUR_");
	    course.setCourseID(id);	    
		Course res=courseRepository.save(course);
		if(res.getCourseID().equals(course.getCourseID()))
			return true;
		else
			return false;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Course> get() {
		return courseRepository.findAll();
	}

}
