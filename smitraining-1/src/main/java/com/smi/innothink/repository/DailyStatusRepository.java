package com.smi.innothink.repository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import com.smi.innothink.domain.DailyStatus;

public interface DailyStatusRepository extends JpaRepository<DailyStatus, String> {
	@Procedure(name = "in_and_out_test_dailystatus")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
	
	@Query(nativeQuery=true,value="select b.batch_name,c.course_name,s.subject_name,t.topic_name from batch b join daily_status d on d.batch_id=b.batch_id join course c\r\n" + 
			"on d.course_id=c.course_id join subject s on d.subject_id=s.subject_id join topic t on d.topic_id=t.topic_id where d.date=:d")
	public ArrayList<String> getDailyStatus(@Param("d")String date);
	
	@Query(nativeQuery=true,value="select d.date,b.batch_name,c.course_name,s.subject_name,t.topic_name from batch b join daily_status d on d.batch_id=b.batch_id join course c\r\n" + 
			"on d.course_id=c.course_id join subject s on d.subject_id=s.subject_id join topic t on d.topic_id=t.topic_id where d.date like :d")
	public ArrayList<String> getMonthlyStatus(@Param("d")String date);
	
	@Query(nativeQuery=true,value="select d.date,c.course_name,s.subject_name,t.topic_name from  daily_status d join  course c\r\n" + 
			"on d.course_id=c.course_id join subject s on d.subject_id=s.subject_id join topic t on d.topic_id=t.topic_id where d.batch_id = :id")
    public ArrayList<String> getBatchwiseStatus(@Param ("id") String batchId);
}
