package com.vilaruel.rafael.pingchat.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.vilaruel.rafael.pingchat.dto.UsersDTO;
import com.vilaruel.rafael.pingchat.model.Users;
import com.vilaruel.rafael.pingchat.repository.PingRoomRepository;
import com.vilaruel.rafael.pingchat.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor
public class UsersService {
	
	private final PingRoomRepository pingRoomRepository;
	private final UsersRepository usersRepository;
	
	public Long createNewUser(UsersDTO newUser) {
		Users user = new Users();
		user.setChatId(newUser.getChatId().longValue());
		user.setName(newUser.getName());
		user.setUserId(ThreadLocalRandom.current().nextLong(3, 100000));	
		
		usersRepository.save(user);
		return user.getUserId();
		
	}
	
	public Users findUser(long id) {
		
		Users user = usersRepository.findById(id);		
		return user;
		
	}

}
