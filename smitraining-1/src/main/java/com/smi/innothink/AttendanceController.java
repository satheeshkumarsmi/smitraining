package com.smi.innothink;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
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
	static Logger log = Logger.getLogger("AttendanceController.class");
	
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
			log.info("Inserting attendance " + attendance.getAttendanceId());
		}
		log.error("Fail to insert Attendance");
		return false;}
	


	@RequestMapping(value = "/updateattendance", method = RequestMethod.POST, produces = "application/json")
	public boolean insertAttendanceProperly(@RequestBody(required = false) AttendanceSession attendanceSession) {
		
		if (attendanceSession.getSession().equals("Forenoon") && attendanceSession.isStatus()) {
			attendanceRepository.updateForenoonAttendance(attendanceSession.getStudentId(),
					attendance.getAttendanceDate());
			log.info("Attendance is updated for forenoon" +attendanceSession.isStatus() + attendanceSession.getStudentId());
		} else if ((attendanceSession.getSession().equals("Afternoon") && attendanceSession.isStatus())) {
			attendanceRepository.updateAfternoonAttendance(attendance.getStudentId(),
					attendance.getAttendanceDate());
			log.info("Attendance is updated for afternoon " + attendanceSession.isStatus() + attendanceSession.getStudentId());
		}
		return false;
	}
	
	@RequestMapping(value = "/getdailyattendance" , method = RequestMethod.GET , produces = "application/json")
	public Iterable getDailyAttendance(@RequestParam String attendanceDate) {
		log.info("Daily attendance details for " +attendanceDate);
		return attendanceRepository.getDailyAttendance(attendanceDate);
	}
	@RequestMapping(value = "/getmonthlyattendance" , method = RequestMethod.GET , produces = "application/json")
	public Iterable getMonthlyAttendance(@RequestParam String attendanceDate) {
		log.info("Monthly attendance details for "+attendanceDate);
		return attendanceRepository.getMonthlyAttendance("%" + attendanceDate + "%");
	}
	
	@RequestMapping(value = "/getbatchwiseattendance" , method = RequestMethod.GET , produces = "application/json")
	public Map getBatchwiseAttendance(@RequestParam String batchId) {
		ArrayList<String> studentId=attendanceRepository.getStudentId(batchId);
		Iterator it=studentId.iterator();
		ArrayList<Serializable> resAbsent=new ArrayList();
	   ArrayList<Serializable> resName=new ArrayList();
		ArrayList<Serializable> resPresent=new ArrayList();
		  Map<String,ArrayList> map =new HashMap();
		  
		while(it.hasNext()) {
			String k=String.valueOf(it.next());
			resName.add(attendanceRepository.getStudentName(k));
			resPresent.add(attendanceRepository.getNumberOfPresents(k));
			resAbsent.add(attendanceRepository.getNumberOfAbsentees(k));	
			}
		map.put("student", resName);
		map.put("present", resPresent);
		map.put("absent" , resAbsent);
		log.info("Batchwise Attendance report");
		return map;
}
	
	@RequestMapping(value = "/getstudentwiseattendance", method=RequestMethod.GET , produces = "application/json")
	public ArrayList getStudentwiseAttendance(@RequestParam String studentId) {
		ArrayList al=new ArrayList();
		al.add(attendanceRepository.getBatchName(studentId));
		al.add(attendanceRepository.getDateOfJoining(studentId));
		al.add(attendanceRepository.getNumberOfPresents(studentId));
		al.add(attendanceRepository.getNumberOfAbsentees(studentId));
		return al;
	}
		
	}
