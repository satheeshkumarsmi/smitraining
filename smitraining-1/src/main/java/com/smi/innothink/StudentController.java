package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.smi.innothink.domain.Qualification;
import com.smi.innothink.domain.Stream;
import com.smi.innothink.repository.QualificationRepository;
import com.smi.innothink.repository.StreamRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/smi")
public class StudentController {
	@Autowired(required=false)
	Qualification qualification;
	
	@Autowired(required=false)
	QualificationRepository qualificationRepository;
	
	@Autowired(required=false)
	Stream stream;
	
	@Autowired(required=false)
	StreamRepository streamRepopsitory;
	
	@RequestMapping(value = "/insertstudentqualification", method=RequestMethod.POST, produces = "application/json")
	public boolean insertStudentQualification(@RequestBody(required=false) Qualification qualification ) {
		Qualification res=qualificationRepository.save(qualification);
		if(res.getqId()==(qualification.getqId()))
			return true;
		else
			return false;
	}

	@RequestMapping(value = "/getstudentqualification", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Qualification> getstudentqualification() {
		return qualificationRepository.findAll();
	}
	
	@RequestMapping(value = "/insertstudentstream", method=RequestMethod.POST, produces = "application/json")
	public boolean insertStudentStream(@RequestBody(required=false) Stream stream ) {
		Stream res=streamRepopsitory.save(stream);
		if(res.getsId()==(stream.getsId()))
			return true;
		else
			return false;
	}

	@RequestMapping(value = "/getstudentstream", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Stream> getstudentStream() {
		return streamRepopsitory.findAll();
	}
}
