package com.smi.innothink;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smi.innothink.controllerinterfaces.StudentControllerInterface;
import com.smi.innothink.domain.AcademicDetails;
import com.smi.innothink.domain.Qualification;
import com.smi.innothink.domain.SaveStudent;
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
import com.smi.innothink.services.RandomPasswordStudent;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class StudentController implements StudentControllerInterface {
	static Logger log = Logger.getLogger("StudentController.class");
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
	@Autowired(required = false)
	StatusDetails statusDetails;
	@Autowired(required = false)
	StatusDetailsRepository statusDetailsRepository;
	@Autowired
	JavaMailSender sender;

	@RequestMapping(value = "/insertstudentstream", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentStream(@RequestBody(required = false) Stream stream) {
		Stream res = streamRepopsitory.save(stream);
		if (res.getsId() == (stream.getsId())) {
			log.info("Insert student stream  " + stream.getsId());
			return true;
		} else {
			log.info("Fail to insert student stream");
			return false;
		}
	}

	@RequestMapping(value = "/getstudentstream", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Stream> getstudentStream() {
		log.info("Get student stream");
		return streamRepopsitory.findAll();
	}

	@RequestMapping(value = "/insertstudentacademic", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentAcademic(@RequestBody(required = false) AcademicDetails academicDetails) {

		String academicId = academicDetailsRepository.getId("student_academic_id", "SMI_IT_ADI_", "academic_details");
		String id1 = AutoIncrement.incrementId(Integer.parseInt(academicId), "SMI_IT_ADI_");
		System.out.println(id1);
		academicDetails.setStudentAcademicId(id1);
		AcademicDetails res1 = academicDetailsRepository.save(academicDetails);
		acId = res1.getStudentAcademicId();
		if ((res1.getStudentAcademicId().equals(academicDetails.getStudentAcademicId()))) {
			log.info("Insert Student Academic details  " + academicDetails.getStudentAcademicId());
			return true;
		}
		else {
			log.info("Fail to insert student academic details");
			return false;
		}
	}

	String acId;
	String pId;

	@RequestMapping(value = "/insertstudentpersonal", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentPersonal(@RequestBody(required = false) StudentPersonal studentPersonal) {
		String personalId = studentPersonalRepository.getId("student_personal_id", "SMI_IT_STUP_", "student_personal");
		String id2 = AutoIncrement.incrementId(Integer.parseInt(personalId), "SMI_IT_STUP_");
		studentPersonal.setStudentPersonalId(id2);
		StudentPersonal res2 = studentPersonalRepository.save(studentPersonal);
		pId = res2.getStudentPersonalId();
		if (res2.getStudentPersonalId().equals(studentPersonal.getStudentPersonalId())) {
			log.info("Insert Student Personal details  " + studentPersonal.getStudentPersonalId());
			return true;
		}
		else {
			log.info("Fail to insert Student personal details ");
			return false;
		}
	}

	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudent(@RequestBody(required = false) SaveStudent saveStudent) {
		AcademicDetails academicDetails=saveStudent.getAcademicDetails();
		StudentPersonal studentPersonal = saveStudent.getStudentPersonal();
		Student student = saveStudent.getStudent();
		System.out.println(student.getMailId());
		String academicId = academicDetailsRepository.getId("student_academic_id", "SMI_IT_ADI_", "academic_details");
		String id1 = AutoIncrement.incrementId(Integer.parseInt(academicId), "SMI_IT_ADI_");
		academicDetails.setStudentAcademicId(id1);
		AcademicDetails res1 = academicDetailsRepository.save(academicDetails);
		acId = res1.getStudentAcademicId();
		String personalId = studentPersonalRepository.getId("student_personal_id", "SMI_IT_STUP_", "student_personal");
		String id2 = AutoIncrement.incrementId(Integer.parseInt(personalId), "SMI_IT_STUP_");
		studentPersonal.setStudentPersonalId(id2);
		StudentPersonal res2 = studentPersonalRepository.save(studentPersonal);
		pId = res2.getStudentPersonalId();
		String studentId = studentRepository.getId("student_id", "SMI_IT_STU_", "student");
		String id3 = AutoIncrement.incrementId(Integer.parseInt(studentId), "SMI_IT_STU_");
		student.setStudentId(id3);
		student.setAcademicId(acId);
		student.setStudentPersonalId(pId);
		String studentPassword=RandomPasswordStudent.randomAlphaNumeric(6);
		student.setStudentPassword(studentPassword);		
		Student res3 = studentRepository.save(student);
		String mail=studentRepository.getMail(id3);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(mail);
		message.setSubject("SMI trainee Username and Password");
		message.setText("Hello "+student.getStudentName()+"Welcome to SMI Innothink.Your Username:"+id3+
		 		"and Your Password:"+studentPassword);
		sender.send(message);
		if(res3.getStudentId().equals(student.getStudentId())) {
	     return true;
		 }
		 else {
			 return false;
		 }
		 
		
	}
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getdeployedstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Student> getDeployedStudentsDetails() {
		log.info("Details of deployed students");
		return studentRepository.getDeployedStudent("deployed");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getdiscontinuedstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Student> getDiscontinuedStudentsDetails() {
		log.info("Details of discontinued students");
		return studentRepository.getDiscontinuedStudent("discontinued");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getterminatedstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Student> getTerminatedStudentsDetails() {
		log.info("Details of Terminated Students");
		return studentRepository.getTerminatedStudent("terminated");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getintrainingstudentsdetails", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Student> getIntrainingStudentsDetails() {
		log.info("Details of students in training");
		return studentRepository.getIntrainingStudent("in-training");
	}
	
	@RequestMapping(value = "/getstudentmobileonname" ,  method = RequestMethod.GET , produces = "application/json")
	public Iterable<Student> getStudent(@RequestParam String name){
		return studentRepository.getName("%"+name+"%");
	}

	@RequestMapping(value = "/insertstudentstatus", method = RequestMethod.POST, produces = "application/json")
	public void insertStudentStatus(@RequestBody(required = false) StatusDetails statusDetails) {
		log.info("Insert Current status of the students");
		statusDetailsRepository.save(statusDetails);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getstudentdetails",method =RequestMethod.GET, produces = "application/json")
	public Iterable getStudentDetails(){
		return studentRepository.getStudent();
	}
}
