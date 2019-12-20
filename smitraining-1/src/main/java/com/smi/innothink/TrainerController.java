package com.smi.innothink;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Course;
import com.smi.innothink.domain.Trainers;
import com.smi.innothink.repository.TrainerRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class TrainerController {
	static Logger log = Logger.getLogger("TrainerController.class");
	@Autowired(required = false)
    Trainers trainers;
	@Autowired(required = false)
	TrainerRepository trainerRepository;
	
	@RequestMapping(value = "/inserttrainers", method = RequestMethod.POST, produces = "application/json")
	public boolean insert(@RequestBody(required = false) Trainers trainers) {

		String trainerId = trainerRepository.getId("trainer_id", "SMI_IT_TRA_", "trainers");
		String id = AutoIncrement.incrementId(Integer.parseInt(trainerId), "SMI_IT_TRA_");
		trainers.setTrainerId(id);
		Trainers res=trainerRepository.save(trainers);
		if(trainers.getTrainerId().equals (res.getTrainerId())) {
			log.info("New Trainer is added" + trainers.getTrainerName());
			log.info("Insert New Trainer  " +res.getTrainerId());
			return true;
		}
			

		else {
			log.info("Fail to insert new trainer");
			return false;
		}
}
	
	@RequestMapping(value = "/gettrainer", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Trainers> get() {
		log.error("Details of trainers");
		return trainerRepository.findAll();

	}
}
