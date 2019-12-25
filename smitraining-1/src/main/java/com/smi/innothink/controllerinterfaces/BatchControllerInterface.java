package com.smi.innothink.controllerinterfaces;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.BatchMapping;
import com.smi.innothink.domain.Student;

public interface BatchControllerInterface {
	 boolean insertBatch( Batch batch);
	 ArrayList<Batch> getBatch();
	 ArrayList<Student> getName(String mobile);
	 boolean insertBatchMapping(BatchMapping batchMapping);
	 ArrayList<Student> getStudentNameAndMobile( String batchId);
	 boolean switchBatch( BatchMapping batchMapping);
	 
}
