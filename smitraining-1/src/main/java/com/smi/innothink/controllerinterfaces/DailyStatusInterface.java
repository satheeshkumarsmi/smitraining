package com.smi.innothink.controllerinterfaces;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.smi.innothink.domain.DailyStatus;

public interface DailyStatusInterface {
	 boolean insertBatch(DailyStatus dailyStatus);
	 Iterable getDailyStatus(String date);
	 Iterable getMonthlyStatus( String date);
	 Iterable getBatchwiseStatus(@RequestParam String batchId);
}
