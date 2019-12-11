package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.BatchMapping;
import com.smi.innothink.domain.BatchStatus;
import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.Student;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.repository.BatchRepository;
import com.smi.innothink.repository.BatchStatusRepository;
import com.smi.innothink.repository.StudentRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/smi")
public class BatchController {
	static Logger log = Logger.getLogger(BatchController.class);



	@Autowired(required=false)
    BatchRepository batchRepository;
	@Autowired(required=false)
	Batch batch;
	@Autowired(required=false)
	BatchStatus batchStatus;
	@Autowired (required=false)
	BatchStatusRepository batchStatusRepository;
	@Autowired(required=false)
	BatchMapping batchMapping;
	@Autowired(required=false)
	BatchMappingRepository batchMappingRepository;
	@Autowired(required = false)
	StudentRepository studentRepository;
	
	@RequestMapping(value = "/insertbatch", method = RequestMethod.POST, produces = "application/json")
	public boolean insertBatch(@RequestBody(required = false) Batch batch) {
		Batch res=null;
		log.info("welcome");
		try {

		String batchId = batchRepository.getId("batch_id", "SMI_IT_BAT_", "batch");
		String id = AutoIncrement.incrementId(Integer.parseInt(batchId), "SMI_IT_BAT_");
		batch.setBatchId(id);
	     res = batchRepository.save(batch);
		
		}
		catch(Exception e) {
			log.fatal("error da",e);
		}
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
		ArrayList<Student> al= studentRepository.getName("%"+mobile+"%");
		return al;
		 
	}
	
	
	
	

}
