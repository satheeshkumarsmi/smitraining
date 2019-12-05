package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.BatchMapping;
import com.smi.innothink.domain.BatchStatus;
import com.smi.innothink.domain.Course;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.repository.BatchRepository;
import com.smi.innothink.repository.BatchStatusRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/smi")
public class BatchController {
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
	public Iterable<Batch> get() {
		return batchRepository.findAll();

	}
	
	
	
	

}
