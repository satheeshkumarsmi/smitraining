package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.AcademicDetails;
import com.smi.innothink.domain.Qualification;
import com.smi.innothink.domain.Stream;
import com.smi.innothink.domain.Student;
import com.smi.innothink.domain.StudentPersonal;
import com.smi.innothink.repository.AcademicDetailsRepository;
import com.smi.innothink.repository.QualificationRepository;
import com.smi.innothink.repository.StreamRepository;
import com.smi.innothink.repository.StudentPersonalRepository;
import com.smi.innothink.repository.StudentRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

	@RequestMapping(value = "/insertstudentqualification", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentQualification(@RequestBody(required = false) Qualification qualification) {
		// int id= qualificationRepository.getId();

		// qualification.setQualificationId(AutoIncrement.getIncrement(id));
		System.out.println(qualification);

		Qualification res = qualificationRepository.save(qualification);
		if (res.getDegree() == (qualification.getDegree()))
			return true;
		else
			return false;
	}

	@RequestMapping(value = "/getstudentqualification", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Qualification> getstudentqualification() {
		return qualificationRepository.findAll();
	}

	@RequestMapping(value = "/insertstudentstream", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentStream(@RequestBody(required = false) Stream stream) {
		Stream res = streamRepopsitory.save(stream);
		if (res.getsId() == (stream.getsId()))
			return true;
		else
			return false;
	}

	@RequestMapping(value = "/getstudentstream", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Stream> getstudentStream() {
		return streamRepopsitory.findAll();
	}

	@RequestMapping(value = "/insertstudentacademic", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentAcademic(@RequestBody(required = false) AcademicDetails academicDetails) {

		String academicId = academicDetailsRepository.getId("student_academic_id", "SMI_IT_ADI_", "academic_details");
		String id1 = AutoIncrement.incrementId(Integer.parseInt(academicId), "SMI_IT_ADI_");
		System.out.println(id1);
		academicDetails.setStudentAcademicId(id1);
		AcademicDetails res1 = academicDetailsRepository.save(academicDetails);
		if ((res1.getStudentAcademicId().equals(academicDetails.getStudentAcademicId())))
			return true;
		else
			return false;
	}

	@RequestMapping(value = "/insertstudentpersonal", method = RequestMethod.POST, produces = "application/json")
	public boolean insertStudentPersonal(@RequestBody(required = false) StudentPersonal studentPersonal) {

		String personalId = studentPersonalRepository.getId("student_personal_id", "SMI_IT_STUP_", "student_personal");
		String id2 = AutoIncrement.incrementId(Integer.parseInt(personalId), "SMI_IT_STUP_");
		System.out.println(id2);
		studentPersonal.setStudentPersonalId(id2);
		StudentPersonal res2 = studentPersonalRepository.save(studentPersonal);
		if (res2.getStudentPersonalId().equals(studentPersonal.getStudentPersonalId()))
			return true;
		else
			return false;

	}

	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST, produces = "application/json")

	public boolean insertStudent(@RequestBody(required = false) Student student) {

		String studentId = studentPersonalRepository.getId("student_id", "SMI_IT_STU_", "student");
		String academicId = academicDetailsRepository.getId("student_academic_id", "SMI_IT_ADI_", "academic_details");
		int k=Integer.parseInt(academicId)+1;
		String personalId = studentPersonalRepository.getId("student_personal_id", "SMI_IT_STUP_", "student_personal");
		int r=Integer.parseInt(personalId)+1;
		String acaId="SMI_IT_ADI_"+k;
		String perId="SMI_IT_STUP_"+r;		
		student.setAcademicId(acaId);
		student.setStudentPersonalId(perId);

		String id3 = AutoIncrement.incrementId(Integer.parseInt(studentId), "SMI_IT_STU_");
		System.out.println(id3);
		student.setStudentId(id3);
		Student res3 = studentRepository.save(student);
		if (res3.getStudentId().equals(student.getStudentId()))
			return true;
		else
			return false;
	}
}
