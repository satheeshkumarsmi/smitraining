package com.smi.innothink.controllerinterfaces;

import org.springframework.web.bind.annotation.RequestBody;

import com.smi.innothink.domain.AcademicDetails;
import com.smi.innothink.domain.StatusDetails;
import com.smi.innothink.domain.Stream;
import com.smi.innothink.domain.Student;
import com.smi.innothink.domain.StudentPersonal;

public interface StudentControllerInterface {
	boolean insertStudentStream(Stream stream);
    Iterable<Stream> getstudentStream();
    boolean insertStudentAcademic(AcademicDetails academicDetails);
    boolean insertStudentPersonal( StudentPersonal studentPersonal);
    boolean insertStudent( Student student);
    Iterable getDeployedStudentsDetails();
    Iterable getDiscontinuedStudentsDetails();
    Iterable getTerminatedStudentsDetails();
    Iterable getIntrainingStudentsDetails();
    void insertStudentStatus(StatusDetails statusDetails); 
}
