package com.smi.innothink.controllerinterfaces;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.smi.innothink.domain.AssignAssesment;
import com.smi.innothink.domain.MarkUpdates;

public interface AssesmentControllerInterface {
	 boolean insertAssesment(AssignAssesment assignAssesment);
	 Map getAssignedAssesment();
	 Map getStudentAndTotal(String assignAssesmentId);
	 boolean insertMarks(MarkUpdates markUpdates);
}
