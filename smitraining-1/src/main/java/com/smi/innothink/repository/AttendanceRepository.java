package com.smi.innothink.repository;

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
    @Query("select b.batchName,s.studentName,a.forenoonSession,a.afternoonSession from Attendance a join Student s on a.studentId=s.studentId join batch b on a.batchId=b.batchId where a.attendanceDate = :date")
    public Iterable getDailyAttendance(@Param("date") String date);
}
