package com.smi.innothink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smi.innothink.controllerinterfaces.AssesmentControllerInterface;
import com.smi.innothink.domain.AssignAssesment;
import com.smi.innothink.domain.AssignAssesmentDetails;
import com.smi.innothink.domain.MarkUpdates;
import com.smi.innothink.domain.ReceiveMark;
import com.smi.innothink.repository.AssignAssesmentRepository;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.repository.BatchRepository;
import com.smi.innothink.repository.MarkUpdatesRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class AssesmentController implements AssesmentControllerInterface {
	static Logger log = Logger.getLogger("AssesmentController.class");
	@Autowired(required = false)
	AssignAssesment assignAssesment;
	@Autowired(required = false)
	AssignAssesmentRepository assignAssesmentRepository;
	@Autowired(required = false)
	MarkUpdates markUpdates;
	@Autowired(required = false)
	MarkUpdatesRepository markUpdatesRepository;
	@Autowired(required = false)
	AssignAssesmentDetails assignAssesmentDetails;
	@Autowired(required = false)
	BatchMappingRepository batchMappingRepository;
	@Autowired(required = false)
	BatchRepository batchRepository;

	@RequestMapping(value = "/insertassesmentdetails", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAssesment(@RequestBody(required = false) AssignAssesment assignAssesment) {
		String assignAssesmentId = assignAssesmentRepository.getId("assign_assesment_id", "SMI_IT_AAI_","assign_assesment");
		String id = AutoIncrement.incrementId(Integer.parseInt(assignAssesmentId), "SMI_IT_AAI_");
		assignAssesment.setAssignAssesmentId(id);
		AssignAssesment res = assignAssesmentRepository.save(assignAssesment);
		if (res.getAssignAssesmentId().equals(assignAssesment.getAssignAssesmentId())) {
			log.info("New Assesment Assigned " + assignAssesment.getAssignAssesmentId());
			return true;
		} else {
			log.error("Fail to Assign new Assesment");
			return true;
		}
	}

	@RequestMapping(value = "/getassignedassesment", method = RequestMethod.GET, produces = "application/json")
	public Map getAssignedAssesment() {
		String k = "assigned";
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		Map<String, Iterable> map = new HashMap();
		al = assignAssesmentRepository.getbatchId(k);
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			String s = String.valueOf(assignAssesmentRepository.getBatchName(it.next()));
			res.add(s);
		}
		map.put("assignedAssesment", assignAssesmentRepository.getAssigned(k));
		map.put("batchName", res);
		return map;
	}

	@RequestMapping(value = "/getstudentandtotal", method = RequestMethod.GET, produces = "application/json")
	public Map getStudentAndTotal(@RequestParam String assignAssesmentId) {
		String batchId = assignAssesmentRepository.getbatchIdOnAssignment(assignAssesmentId);
		ArrayList<String> al = batchMappingRepository.getStudent(batchId);
		Map<String, ArrayList> map = new HashMap();
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<Double> totalMarks = new ArrayList<Double>();
		Iterator<String> it = al.iterator();
		while (it.hasNext()) {
			String k = batchRepository.getStudentName(it.next());
			res.add(k);
			totalMarks.add(assignAssesmentRepository.getTotalMarks(assignAssesmentId));
		}
		map.put("studentId", al);
		map.put("studentName", res);
		map.put("total", totalMarks);
		return map;
	}

	

	@RequestMapping(value = "/insertmarks", method = RequestMethod.POST, produces = "application/json")  
	public boolean insertMarks2(@RequestBody String mark[]) {
		//String test[]=receiveMark.getMark();
		for(int i=0;i<mark.length;i++)
		{
			//String result[]=test[i].split("/");
			System.out.println(mark.length);
			//for(int j=0;j<result.length;j++) {
		//		System.out.println(result[j]);
			//}
		}
      return false;
	}
	}
