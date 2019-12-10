package com.smi.innothink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.smi.innothink.domain.Topic;

public interface TopicRepository extends JpaRepository<Topic, String>{


	@Procedure(name = "in_and_out_test_topic")
    String getId(@Param("inParam") String inParam,@Param("inParam1") String inParam1,@Param("outParam1") String inParam2);
	@Query(" from Topic t where t.subjectId=:id")

	Iterable<Topic> getTopics( @Param ("id")String subjectId);

}
