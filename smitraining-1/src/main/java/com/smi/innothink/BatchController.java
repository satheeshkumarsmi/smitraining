package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.Logger;
import com.smi.innothink.controllerinterfaces.BatchControllerInterface;
import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.BatchMapping;
import com.smi.innothink.domain.BatchStatus;
import com.smi.innothink.domain.Student;
import com.smi.innothink.domain.SwitchBatch;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.repository.BatchRepository;
import com.smi.innothink.repository.BatchStatusRepository;
import com.smi.innothink.repository.StudentPersonalRepository;
import com.smi.innothink.repository.StudentRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class BatchController implements BatchControllerInterface {
	static Logger log = Logger.getLogger("BatchController.class");
	@Autowired(required = false)
	BatchRepository batchRepository;
	@Autowired(required = false)
	Batch batch;
	@Autowired(required = false)
	BatchStatus batchStatus;
	@Autowired(required = false)
	BatchStatusRepository batchStatusRepository;
	@Autowired(required = false)
	BatchMapping batchMapping;
	@Autowired(required = false)
	BatchMappingRepository batchMappingRepository;
	@Autowired(required = false)
	StudentRepository studentRepository;
	@Autowired(required = false)
	StudentPersonalRepository studentpersonalRepository;
	@Autowired(required = false)
	SwitchBatch switchBatch;

	@RequestMapping(value = "/insertbatch", method = RequestMethod.POST, produces = "application/json")
	public boolean insertBatch(@RequestBody(required = false) Batch batch) {
		String batchId = batchRepository.getId("batch_id", "SMI_IT_BAT_", "batch");
		String id = AutoIncrement.incrementId(Integer.parseInt(batchId), "SMI_IT_BAT_");
		batch.setBatchId(id);
		Batch res = batchRepository.save(batch);
		if (res.getBatchId().equals(batch.getBatchId())) {
			log.info("New batch Inserted " + batch.getBatchId());
			return true;
		} else {
			log.error("Fail to Insert New Batch");
			return true;
		}

	}

	@RequestMapping(value = "/getbatch", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Batch> getBatch() {
		log.info("List of batches");
		log.info("Get Batch Details");
		return batchRepository.getBatch();
	}

	@RequestMapping(value = "/getname", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Student> getName(@RequestParam("mobile") String mobile) {

		log.info("Get the student name according to their mobile number");
		System.out.println(mobile);
		ArrayList<Student> al = studentRepository.getName("%" + mobile + "%");
		log.info("Find the name of student based on Mobilenumber");
		return al;

	}

	@RequestMapping(value = "/insertbatchmapping", method = RequestMethod.POST, produces = "application/json")
	public boolean insertBatchMapping(@RequestBody(required = false) BatchMapping batchMapping) {

		BatchMapping res = batchMappingRepository.save(batchMapping);
		if (res.getId() == batchMapping.getId()) {
			log.info("Mapping of Student and Batches  " + batchMapping.getStudentId() + batchMapping.getBatchId());
			log.info("Insert Student and Batch Mapping  " + batchMapping.getId());
			return true;
		}
		else {
			log.info("Fail to insert Batch Mapping");
			return false;
		}

	}

	@RequestMapping(value = "/getstudentnameandmobile", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Student> getStudentNameAndMobile(@RequestParam String batchId) {
		ArrayList<String> al = batchMappingRepository.getStudent(batchId);
		ArrayList<Student> res = new ArrayList<Student>();
		Iterator it = al.iterator();
		while (it.hasNext()) {
			String k = String.valueOf(it.next());
			Student k1 = (studentRepository.getStudent(k));
			res.add(k1);
		}
		log.info("Details of student based on Batch");
		return res;
	}

	@RequestMapping(value = "/switchbatch", method = RequestMethod.POST, produces = "application/java")
	public boolean switchBatch(@RequestBody(required = false) BatchMapping batchMapping) {
		String studentId = batchMapping.getStudentId();
		String batchId = batchMapping.getBatchId();
		String date =batchMapping.getAssignedDate();
		batchMappingRepository.remove(studentId);
		batchMapping.setStudentId(studentId);
		batchMapping.setBatchId( batchId);
		batchMapping.setAssignedDate(date);
		System.out.println(batchMapping);
		BatchMapping b = batchMappingRepository.save(batchMapping);
		System.out.println(b);
		log.info(
				"Change the batch of the student " + batchMapping.getStudentId() + "into " + batchMapping.getBatchId());
		return false;
	}

}
