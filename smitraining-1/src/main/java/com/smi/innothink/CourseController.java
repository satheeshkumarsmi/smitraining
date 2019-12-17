package com.smi.innothink;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.Subject;
import com.smi.innothink.domain.Topic;
import com.smi.innothink.repository.CourseRepository;
import com.smi.innothink.repository.SubjectRepository;
import com.smi.innothink.repository.TopicRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class CourseController {
	static Logger log = Logger.getLogger("CourseController.class");
	@Autowired
	CourseRepository courseRepository;

	@Autowired(required = false)
	Course course;

	@Autowired(required = false)
	SubjectRepository subjectRepository;
	@Autowired(required = false)
	Subject subject;

	@Autowired(required = false)
	TopicRepository topicRepository;

	@Autowired(required = false)
	Topic topic;

	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json")
	public boolean insert(@RequestBody(required = false) Course course) {
		String courseId = courseRepository.getId("courseid", "SMI_IT_CUR_", "Course");
		String id = AutoIncrement.incrementId(Integer.parseInt(courseId), "SMI_IT_CUR_");
		course.setCourseID(id);
		System.out.println(course.getCourseID());
		System.out.println(course.getCourse_name());
		System.out.println(course.getDescription());
		Course res = courseRepository.save(course);
		if (res.getCourseID().equals(course.getCourseID())) {
			log.info("Insert Course Details  " +course.getCourseID());
			return true;
		}
		else {
			log.info("Fail to insert course");
			return false;
			}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Course> get() {
		log.info("Get course details");
		return courseRepository.findAll();
		}

	@RequestMapping(value = "/insertsubject", method = RequestMethod.POST, produces = "application/json")
	public boolean insertSubject(@RequestBody(required = false) Subject subject) {
		String subjectId = subjectRepository.getId("subject_id", "SMI_IT_SUB_", "subject");
		String id = AutoIncrement.incrementId(Integer.parseInt(subjectId), "SMI_IT_SUB_");
		subject.setSubjectId(id);
		Subject res = subjectRepository.save(subject);
		if (res.getSubjectId().equals(subject.getSubjectId())) {
			log.info("Insert Subject details  " + subject.getSubjectId());
			return true;
		}
		else {
			log.info("Fail to insert subject");
			return false;
		}
			
	}

	@RequestMapping(value = "/getsubject", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Subject> getSubject() {
		log.info("Get subject details");
		return subjectRepository.findAll();
	}

	@RequestMapping(value = "/getsubjectoncourse", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Subject> getSubjectOnCourse(@RequestParam("courseId") String courseId) {
		log.info("Get details about subject on course");
		return subjectRepository.getSubjects(courseId);
	}

	@RequestMapping(value = "/inserttopic", method = RequestMethod.POST, produces = "application/json")
	public boolean insertSubject(@RequestBody(required = false) Topic topic) {
		String topicId = topicRepository.getId("topic_id", "SMI_IT_TOP_", "topic");
		String id = AutoIncrement.incrementId(Integer.parseInt(topicId), "SMI_IT_TOP_");
		topic.setTopicId(id);
		Topic res = topicRepository.save(topic);
		if (res.getTopicId().equals(topic.getTopicId())) {
			log.info("Inserting topics  " + topic.getTopicId());
			return true;
		}
		else
			return false;
	}

	@RequestMapping(value = "/gettopic", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Topic> getTopic() {
		log.info("Get topic details");
		return topicRepository.findAll();
	}
	
	@RequestMapping(value = "/gettopiconsubject", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Topic> getTopicOnSubject(@RequestParam("subjectId") String subjectId) {
		log.info("Get topic on subject ");
		return topicRepository.getTopics(subjectId);
	}
	

}
