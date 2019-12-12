package com.smi.innothink.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smi.innothink.domain.SmiUserDetails;
import com.smi.innothink.domain.Trainers;
import com.smi.innothink.repository.TrainerRepository;

@Service
public class SmiUserService implements UserDetailsService {
	
	@Autowired
	TrainerRepository trainerRepository;

	@Override
	public UserDetails loadUserByUsername(String trainerName) throws UsernameNotFoundException {
		
		
		
		
		Optional<Trainers> opt=trainerRepository.findBytrainerName(trainerName);
		
		opt.orElseThrow(()-> new UsernameNotFoundException("not found"));
	//	return opt.map(SmiUserDetails::new).get();
		return null;
		
	}

}
