package com.smi.innothink.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,  String> {

	@Procedure(name = "in_and_out_test_attendance")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
	@Transactional
	@Modifying
	@Query("update Attendance set forenoonSession=true where studentId=:Id and attendanceDate=:date")
	void updateForenoonAttendance(@Param("Id") String studentId,@Param("date") String date);
	@Transactional
	@Modifying
	@Query("update Attendance set afternoonSession=true where studentId=:Id and attendanceDate=:date")
	void updateAfternoonAttendance(@Param("Id") String studentId,@Param("date") String date);
 
	@Query("select b.batchName,s.studentName,a.forenoonSession,a.afternoonSession from Attendance a join Student s on a.studentId=s.studentId join Batch b on a.batchId=b.batchId where a.attendanceDate = :date")
    public ArrayList getDailyAttendance(@Param("date") String date);
	@Query("select b.batchName,s.studentName,a.forenoonSession,a.afternoonSession from Attendance a join Student s on a.studentId=s.studentId join Batch b on a.batchId=b.batchId where a.attendanceDate like :date")
	public ArrayList getMonthlyAttendance(@Param ("date") String date);
	
	
	@Query("select a.studentId from BatchMapping a where a.batchId=:id")
	public ArrayList<String> getStudentId(@Param("id") String batchId);
	@Query("select s.studentName from Student s where s.studentId=:id")
	public ArrayList getStudentName(@Param ("id") String studentId);
	@Query("Select count(a.attendanceId ) from Attendance a where a.studentId= :id and a.forenoonSession=true and a.afternoonSession=true")
	public Integer getNumberOfPresents(@Param ("id") String studentId);
	
	@Query("Select count(a.attendanceId ) from Attendance a where a.studentId=:id and a.forenoonSession=false and a.afternoonSession=false")
	public Integer getNumberOfAbsentees(@Param ("id") String studentId);
	
	@Query("select b.batchName from Batch b join BatchMapping bm on bm.batchId=b.batchId where bm.studentId=:id")
	public String getBatchName(@Param ("id") String studentId);
	
	@Query("select s.dateOfJoining from Student s where s.studentId=:id")
	public String getDateOfJoining(@Param ("id") String studentId);
}
