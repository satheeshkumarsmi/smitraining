package com.smi.innothink.controllerinterfaces;

import org.springframework.web.bind.annotation.RequestBody;

import com.smi.innothink.domain.Trainers;

public interface TrainerControllerInterface {
	 boolean insert(Trainers trainers);
	 Iterable<Trainers> get();
}
