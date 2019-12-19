package com.smi.innothink;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smi.innothink.domain.Attendance;
import com.smi.innothink.domain.AttendanceSession;
import com.smi.innothink.domain.DateBatch;
import com.smi.innothink.domain.Trainers;
import com.smi.innothink.repository.AttendanceRepository;
import com.smi.innothink.repository.BatchMappingRepository;
import com.smi.innothink.services.AutoIncrement;

@RestController
@CrossOrigin
@RequestMapping("/smi")
public class AttendanceController {
	@Autowired(required = false)
	Attendance attendance;
	@Autowired(required = false)
	AttendanceRepository attendanceRepository;
	@Autowired(required = false)
	BatchMappingRepository batchMappingRepository;
	@Autowired(required = false)
	DateBatch dateBatch;

	@RequestMapping(value = "/insertattendance", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAttendance(@RequestBody(required = false) DateBatch dateBatch) {
		System.out.println(dateBatch.getBatchId());
		System.out.println(dateBatch.getAttendanceDate());
		ArrayList<String> al = batchMappingRepository.getStudent(dateBatch.getBatchId());
		Iterator<String> it = al.iterator();
		String date = dateBatch.getAttendanceDate();
		attendance = new Attendance();
		while (it.hasNext()) {
			attendance.setAttendanceDate(date);
			attendance.setBatchId(dateBatch.getBatchId());
			attendance.setForenoonSession(false);
			attendance.setAfternoonSession(false);
			attendance.setStudentId(String.valueOf(it.next()));
			System.out.println(attendance.getAttendanceDate());
			String attendanceId = attendanceRepository.getId("attendance_id", "SMI_IT_ATD_", "attendance");
			String id = AutoIncrement.incrementId(Integer.parseInt(attendanceId), "SMI_IT_ATD_");
			attendance.setAttendanceId(id);
			attendanceRepository.save(attendance);
		}

		return false;
	}

	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAttendanceProperly(@RequestBody(required = false) AttendanceSession attendanceSession) {
		System.out.println(attendanceSession.getSession());
		System.out.println(attendanceSession.getStudentId());
		System.out.println(attendance.getAttendanceDate());
		System.out.println(attendanceSession.isStatus());
		if (attendanceSession.getSession().equals("Forenoon") && attendanceSession.isStatus()) {
			attendanceRepository.updateForenoonAttendance(attendanceSession.getStudentId(),
					attendance.getAttendanceDate());
		} else if ((attendanceSession.getSession().equals("Afternoon") && attendanceSession.isStatus())) {
			attendanceRepository.updateAfternoonAttendance(attendance.getStudentId(),
					attendance.getAttendanceDate());
		}
		return false;
	}
	
	@RequestMapping(value = "/getdailyattendance" , method = RequestMethod.GET , produces = "application/json")
	public Iterable getDailyAttendance(@RequestParam String date) {
		return attendanceRepository.getDailyAttendance(date);
	}
}
