package com.smi.innothink;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Attendance;
import com.smi.innothink.domain.Trainers;
import com.smi.innothink.repository.AttendanceRepository;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class AttendanceController {
	static Logger log = Logger.getLogger("AttendanceController.class");
	@Autowired(required = false)
	Attendance attendance;
	@Autowired(required = false)
	AttendanceRepository attendanceRepository;
	@Autowired(required = false)
	BatchMappingRepository batchMappingRepository;

	@RequestMapping(value = "/insertattendance", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAttendance(@RequestBody(required = false) @RequestParam String batchId,@RequestParam String date) {
        ArrayList<String> al=batchMappingRepository.getStudent(batchId);
        Iterator<String> it=al.iterator();
        while(it.hasNext()) {
        	attendance.setAttendanceDate(date);
        	attendance.setBatchId(batchId);
        	attendance.setForenoonSession(false);
        	attendance.setAfternoonSession(false);
        	attendance.setStudentId(String.valueOf(it.next()));

    		String attendanceId = attendanceRepository.getId("attendance_id", "SMI_IT_ATD_", "attendance");
    		String id = AutoIncrement.incrementId(Integer.parseInt(attendanceId), "SMI_IT_ATD_");
    		attendance.setAttendanceId(id);
    		log.info("Attendance is inserted  " +attendance.getAttendanceDate() + attendance.getBatchId() + attendance.getAttendanceId());
        	
        }
			log.info("Fail to insert attendence");
			return false;

	}
}

