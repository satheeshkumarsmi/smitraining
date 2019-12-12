package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.BatchMapping;
import com.smi.innothink.domain.BatchStatus;
import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.Qualification;
import com.smi.innothink.domain.Student;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.repository.BatchRepository;
import com.smi.innothink.repository.BatchStatusRepository;
import com.smi.innothink.repository.StudentPersonalRepository;
import com.smi.innothink.repository.StudentRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class BatchController {

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

	@RequestMapping(value = "/insertbatch", method = RequestMethod.POST, produces = "application/json")
	public boolean insertBatch(@RequestBody(required = false) Batch batch) {

		String batchId = batchRepository.getId("batch_id", "SMI_IT_BAT_", "batch");
		String id = AutoIncrement.incrementId(Integer.parseInt(batchId), "SMI_IT_BAT_");
		batch.setBatchId(id);
		Batch res = batchRepository.save(batch);
		if (res.getBatchId().equals(batch.getBatchId()))
			return true;
		else
			return false;

	}

	@RequestMapping(value = "/getbatch", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Batch> get() {
		return batchRepository.getBatch();
	}

	@RequestMapping(value = "/getname", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Student> getName(@RequestParam("mobile") String mobile) {
		System.out.println(mobile);
		ArrayList<Student> al = studentRepository.getName("%" + mobile + "%");
		return al;

	}

	@RequestMapping(value = "/insertbatchmapping", method = RequestMethod.POST, produces = "application/json")
	public boolean insertBatchMapping(@RequestBody(required = false) BatchMapping batchMapping) {

		System.out.println(batchMapping);
		BatchMapping res = batchMappingRepository.save(batchMapping);
		if (res.getId() == batchMapping.getId())
			return true;
		else
			return false;
	}

	@RequestMapping(value = "/getstudentnameandmobile", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Student> getStudentNameAndMobile(@RequestParam String batchId) {
		ArrayList<String> al=batchMappingRepository.getStudent(batchId);
		ArrayList<Student> res=new ArrayList<Student>();
		Iterator it=al.iterator();
		while(it.hasNext()) {
			String k=String.valueOf(it.next());
			System.out.println(k);
			Student k1=(studentRepository.getStudent(k));
			 System.out.println(k1);
			 	res.add(k1);
				
			}
		return res;
		}}
		 
		


