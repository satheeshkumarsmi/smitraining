package com.smi.innothink;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Batch;
import com.smi.innothink.domain.DailyStatus;
import com.smi.innothink.repository.DailyStatusRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class DailyStatusController {
	static Logger log = Logger.getLogger("DailyStatusController.class");
@Autowired(required=false)
DailyStatus dailyStatus;
@Autowired(required=false)
DailyStatusRepository dailyStatusRepository;

@RequestMapping(value = "/insertdailystatus", method = RequestMethod.POST, produces = "application/json")
public boolean insertBatch(@RequestBody(required = false) DailyStatus dailyStatus ) {

	String dailyStatusId = dailyStatusRepository.getId("daily_status_id", "SMI_IT_DSI_", "daily_status");
	String id = AutoIncrement.incrementId(Integer.parseInt(dailyStatusId), "SMI_IT_DSI_");
	dailyStatus.setDailyStatusId(id);
	DailyStatus res = dailyStatusRepository.save(dailyStatus);
	if (res.getDailyStatusId().equals(dailyStatus.getDailyStatusId())) {
		log.info("Insert Daily status report  " +dailyStatus.getDailyStatusId());
		return true;
	}
	else {
		log.info("Fail to insert daily status report");
		return false;
	}
}
}
