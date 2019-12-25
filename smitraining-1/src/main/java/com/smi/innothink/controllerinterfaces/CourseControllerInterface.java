package com.smi.innothink.controllerinterfaces;



import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.Subject;
import com.smi.innothink.domain.Topic;

public interface CourseControllerInterface {
	boolean insertCourse( Course course);
	Iterable<Course> get();
	boolean insertSubject( Subject subject);
    Iterable<Subject> getSubject();
    Iterable<Subject> getSubjectOnCourse(String courseId);
    boolean insertTopic(Topic topic);
    Iterable<Topic> getTopic();
	Iterable<Topic> getTopicOnSubject(String subjectId);

}
