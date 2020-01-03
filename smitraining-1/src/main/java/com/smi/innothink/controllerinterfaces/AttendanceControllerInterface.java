package com.smi.innothink.controllerinterfaces;
import java.util.ArrayList;
import java.util.Map;
import com.smi.innothink.domain.AttendanceSession;
import com.smi.innothink.domain.DateBatch;

public interface AttendanceControllerInterface {
  void insertAttendance(DateBatch dateBatch);
  boolean insertAttendanceProperly(AttendanceSession attendanceSession);
  Iterable getDailyAttendance(String attendanceDate);
  Iterable getMonthlyAttendance(String attendanceDate);
  Map getBatchwiseAttendance(String batchId);
  ArrayList getStudentwiseAttendance(String studentId);
}
