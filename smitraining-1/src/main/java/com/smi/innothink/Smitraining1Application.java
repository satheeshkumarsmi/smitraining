package com.smi.innothink;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // (scanBasePackages={"com.smi.innothink.controller"})
public class Smitraining1Application {
	static Logger log = Logger.getLogger("Smitraining1Application.class");

	public static void main(String[] args) {
		SpringApplication.run(Smitraining1Application.class, args);
		BasicConfigurator.configure();
		// AttendanceController attendanceController = new AttendanceController();
		// attendanceController.insertAttendance("SMI_IT_BAT_1", "cccc");
		log.info("Welcome to SMI Training Division");
	}

}
