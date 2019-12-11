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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/smi")
public class AttendanceController {
	@Autowired(required=false)
	Attendance attendance;
	@Autowired(required=false)
	AttendanceRepository attendanceRepository;
	
	@RequestMapping(value = "/insertattendance", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAttendance(@RequestBody(required = false) Trainers trainers) {
		return false;
	}
}
