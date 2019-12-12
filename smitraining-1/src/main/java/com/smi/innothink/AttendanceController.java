package com.smi.innothink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Attendance;
import com.smi.innothink.domain.Trainers;
import com.smi.innothink.repository.AttendanceRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class AttendanceController {
	@Autowired(required=false)
	Attendance attendance;
	@Autowired(required=false)
	AttendanceRepository attendanceRepository;
	
	@RequestMapping(value = "/insertattendance", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAttendance(@RequestBody(required = false) Attendance attendance) {

		String attendanceId = attendanceRepository.getId("attendance_id", "SMI_IT_ATD_", "attendance");
		String id = AutoIncrement.incrementId(Integer.parseInt(attendanceId), "SMI_IT_ATD_");
		attendance.setAttendanceId(id);
		Attendance res=attendanceRepository.save(attendance);
		System.out.println();
		if(res.getAttendanceId().equals(attendance.getAttendanceId())){
			return true;
		}
		else
			return false;
		
		
	}
}
