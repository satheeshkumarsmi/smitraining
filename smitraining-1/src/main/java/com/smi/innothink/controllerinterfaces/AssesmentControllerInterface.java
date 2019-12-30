package com.smi.innothink.controllerinterfaces;

import java.util.Map;


import com.smi.innothink.domain.AssignAssesment;

public interface AssesmentControllerInterface {
	 boolean insertAssesment(AssignAssesment assignAssesment);
	 Map getAssignedAssesment();
	 Map getStudentAndTotal(String assignAssesmentId);
	// boolean insertMarks(MarkUpdates[] markUpdates);
	 boolean insertMarks2( String mark[]);
}
