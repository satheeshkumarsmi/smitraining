package com.smi.innothink;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.AcademicDetails;
import com.smi.innothink.domain.Qualification;
import com.smi.innothink.domain.StatusDetails;
import com.smi.innothink.domain.Stream;
import com.smi.innothink.domain.Student;
import com.smi.innothink.domain.StudentPersonal;
import com.smi.innothink.repository.AcademicDetailsRepository;
import com.smi.innothink.repository.QualificationRepository;
import com.smi.innothink.repository.StatusDetailsRepository;
import com.smi.innothink.repository.StreamRepository;
import com.smi.innothink.repository.StudentPersonalRepository;
import com.smi.innothink.repository.StudentRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class StudentController {
	@Autowired(required = false)
	Qualification qualification;

	@Autowired(required = false)
	QualificationRepository qualificationRepository;

	@Autowired(required = false)
	Stream stream;

	@Autowired(required = false)
	StreamRepository streamRepopsitory;

	@Autowired(required = false)
	Student student;
	@Autowired(required = false)
	StudentPersonal studentPersonal;
	@Autowired(required = false)
	StudentPersonalRepository studentPersonalRepository;
	@Autowired(required = false)
	AcademicDetails academicDetails;
	@Autowired(required = false)
	AcademicDetailsRepository academicDetailsRepository;
	@Autowired(required = false)
	StudentRepository studentRepository;
	
	@Autowired(required=false)
	StatusDetails statusDetails;
	@Autowired(required=false)
	StatusDetailsRepository statusDetailsRepository;
	
	static Logger log=Logger.getLogger("StudentController.class");
	
	
	@RequestMapping(value = "/insertstudentqualification", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentQualification(@RequestBody(required = false) Qualification qualification) {
		// int id= qualificationRepository.getId();

		// qualification.setQualificationId(AutoIncrement.getIncrement(id));
		

		Qualification res = qualificationRepository.save(qualification);
		if (res.getDegree() == (qualification.getDegree())) {
			log.info("Student Qualification Inserted");
			return true;
		}
		else {
			log.error("Fail to insert qualification details");
			return false;
		}
			
	}

	@RequestMapping(value = "/getstudentqualification", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Qualification> getstudentqualification() {
		log.info("Find the qualification of the student ");
		return qualificationRepository.findAll();
	}

	@RequestMapping(value = "/insertstudentstream", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentStream(@RequestBody(required = false) Stream stream) {
		Stream res = streamRepopsitory.save(stream);
		if (res.getsId() == (stream.getsId())) {
			log.info("Insert Student Stream");
			return true;
		}
		else {
			log.error("Fail to insert Student stream");
			return false;
	}
	}
	@RequestMapping(value = "/getstudentstream", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Stream> getstudentStream() {
		log.info("Find the Stream of the student");
		return streamRepopsitory.findAll();
	}

	@RequestMapping(value = "/insertstudentacademic", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentAcademic(@RequestBody(required = false) AcademicDetails academicDetails) {

		String academicId = academicDetailsRepository.getId("student_academic_id", "SMI_IT_ADI_", "academic_details");
		String id1 = AutoIncrement.incrementId(Integer.parseInt(academicId), "SMI_IT_ADI_");
		System.out.println(id1);
		academicDetails.setStudentAcademicId(id1);
		AcademicDetails res1 = academicDetailsRepository.save(academicDetails);
		acId=res1.getStudentAcademicId();
		if ((res1.getStudentAcademicId().equals(academicDetails.getStudentAcademicId()))) {
			log.info("Student Academic Details are inserted");
			return true;
		}
		else {
			log.error("Fail to insert Student academic details ");
			return false;
		}
			
	}
	String acId;
	String pId;

	@RequestMapping(value = "/insertstudentpersonal", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentPersonal(@RequestBody(required = false) StudentPersonal studentPersonal) {

		String personalId = studentPersonalRepository.getId("student_personal_id", "SMI_IT_STUP_", "student_personal");
		String id2 = AutoIncrement.incrementId(Integer.parseInt(personalId), "SMI_IT_STUP_");
		System.out.println(id2);
		studentPersonal.setStudentPersonalId(id2);
		StudentPersonal res2 = studentPersonalRepository.save(studentPersonal);
		pId=res2.getStudentPersonalId();
		if (res2.getStudentPersonalId().equals(studentPersonal.getStudentPersonalId())) {
			log.info("Student personal details are inserted");
			return true;
		}
		else {
			log.error("Fail to insert student personal details");
			return false;
		}
	}

	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST, produces = "application/json")

	public boolean insertStudent(@RequestBody(required = false) Student student) {

		String studentId = studentPersonalRepository.getId("student_id", "SMI_IT_STU_", "student");
		student.setAcademicId(acId);
		student.setStudentPersonalId(pId);
		String id3 = AutoIncrement.incrementId(Integer.parseInt(studentId), "SMI_IT_STU_");
		System.out.println(id3);
		student.setStudentId(id3);
		Student res3 = studentRepository.save(student);
		if (res3.getStudentId().equals(student.getStudentId())) {
			log.info("Insert new Student");
			return true;
		}
		else {
			log.error("Fail to insert new student");
			return false;
	}
	}
	@RequestMapping(value = "/getdeployedstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable getDeployedStudentsDetails()
	{
		log.info("Details of deployed students");
		return studentRepository.getDeployedStudent("deployed");
	}
	
	@RequestMapping(value = "/getdiscontinuedstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable getDiscontinuedStudentsDetails()
	{
		log.info("Details of discontinued students");
		return studentRepository.getDiscontinuedStudent("discontinued");
	}

	@RequestMapping(value = "/getterminatedstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable getTerminatedStudentsDetails()
	{
		log.info("Details of Terminated Students");
		return studentRepository.getTerminatedStudent("terminated");
	}
	@RequestMapping(value = "/getintrainingstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable getIntrainingStudentsDetails()
	{
		log.info("Details of students in training");
		return studentRepository.getIntrainingStudent("in-training");
	}
	
	@RequestMapping(value = "/insertstudentstatus", method = RequestMethod.POST, produces = "application/json")
	public void insertStudentStatus(@RequestBody(required = false) StatusDetails statusDetails) {
		log.info("Insert Current status of the students");
		statusDetailsRepository.save(statusDetails);
		
		
	}
}
