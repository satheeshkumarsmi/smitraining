package com.smi.innothink;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.smi.innothink.controllerinterfaces.DailyStatusInterface;
import com.smi.innothink.domain.DailyStatus;
import com.smi.innothink.repository.DailyStatusRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class DailyStatusController implements DailyStatusInterface {

	@Autowired(required = false)
	DailyStatus dailyStatus;
	@Autowired(required = false)
	DailyStatusRepository dailyStatusRepository;
	static Logger log = Logger.getLogger("DailyStatusController.class");

	@RequestMapping(value = "/insertdailystatus", method = RequestMethod.POST, produces = "application/json")
	public boolean insertBatch(@RequestBody(required = false) DailyStatus dailyStatus) {
		String dailyStatusId = dailyStatusRepository.getId("daily_status_id", "SMI_IT_DSI_", "daily_status");
		String id = AutoIncrement.incrementId(Integer.parseInt(dailyStatusId), "SMI_IT_DSI_");
		dailyStatus.setDailyStatusId(id);
		DailyStatus res = dailyStatusRepository.save(dailyStatus);
		if (res.getDailyStatusId().equals(dailyStatus.getDailyStatusId())) {
			log.info("Daily status Inserted ");
			return true;
		} else {
			log.error("Fail to insert DailyStatus");
			return false;
		}
	}

	@RequestMapping(value = "/getdailystatus", method = RequestMethod.GET, produces = "application/json")
	public Iterable getDailyStatus(@RequestParam String date) {
		return dailyStatusRepository.getDailyStatus(date);
	}

	@RequestMapping(value = "/getmonthlystatus", method = RequestMethod.GET, produces = "application/json")
	public Iterable getMonthlyStatus(@RequestParam String date) {
		return dailyStatusRepository.getMonthlyStatus("%" + date + "%");
	}

	@RequestMapping(value = "/getbatchwisestatus", method = RequestMethod.GET, produces = "application/json")
	public Iterable getBatchwiseStatus(@RequestParam String batchId) {
		return dailyStatusRepository.getBatchwiseStatus(batchId);
	}
}