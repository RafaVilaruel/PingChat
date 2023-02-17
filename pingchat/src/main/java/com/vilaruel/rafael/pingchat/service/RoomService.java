package com.vilaruel.rafael.pingchat.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vilaruel.rafael.pingchat.dto.PingRoomDTO;
import com.vilaruel.rafael.pingchat.dto.PingRoomResponseDTO;
import com.vilaruel.rafael.pingchat.dto.UsersDTO;
import com.vilaruel.rafael.pingchat.model.PingRoom;
import com.vilaruel.rafael.pingchat.model.Users;
import com.vilaruel.rafael.pingchat.repository.PingRoomRepository;
import com.vilaruel.rafael.pingchat.repository.UsersRepository;
import com.vilaruel.rafael.pingchat.utils.RoomUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomService {
	
	private final PingRoomRepository pingRoomRepository;
	private final UsersRepository usersRepository;
	private final UsersService usersService;
	private final RoomUtils roomUtils;
		
	public PingRoomResponseDTO createNewRoom(PingRoomDTO roomInfo) {
		
		//Validating if the current user already has an active Room
		Users user = usersService.findUser(roomInfo.getUserId());
		Boolean previousRoomDeleted = Boolean.FALSE;
		PingRoomResponseDTO response = new PingRoomResponseDTO();
		Long hostId = null;
		
		//If he does, we're deleting it and flagging on the response
		if (user != null){
			hostId = user.getUserId();
			if (user.getChatId() != null) {
				usersRepository.deleteById(hostId);
				pingRoomRepository.deleteById(user.getChatId());
				previousRoomDeleted = Boolean.TRUE;
			}}
		
		//Creating the Chat Room
		PingRoom pingRoom = new PingRoom();
		pingRoom.setChat_id((ThreadLocalRandom.current().nextLong(3, 100000)));
		pingRoom.setChatPassword(roomInfo.getChatPassword());
		
		//If the user is new, we're going to create one
		if (hostId == null) {
					UsersDTO newUser = new UsersDTO();
					newUser.setChatId(pingRoom.getChat_id());
					newUser.setName(roomInfo.getUserName());
					hostId = usersService.createNewUser(newUser);
		}
		//Otherwise let's just save the new Room into the User
		else { 
			user.setChatId(pingRoom.getChat_id());
			usersRepository.save(user); 
		}
			
		//Saving the Chat Room
		pingRoom.setUserHost(hostId.longValue());
		pingRoomRepository.save(pingRoom);	
		
		//Setting the response
		response.setChatId(pingRoom.getChat_id());
		response.setPreviousRoomDeleted(previousRoomDeleted);
		response.setUserId(hostId);
		
		return response;		
		
	}
	
	public String loginRoom(PingRoomDTO roomInfo) {
		
		Users user = usersService.findUser(roomInfo.getUserId());
		PingRoom room = this.findRoom(roomInfo.getChatId());
		Long hostId = null;
		
		//checking if password matches
		try {			
			roomUtils.validateLogin(room, roomInfo);
		} catch (Exception e) {			
			return "Não foi possivel entrar nessa sala. Tente criar outra!";
		}
		
		//If the user is new, we're going to create one
		if (user != null) hostId = user.getUserId();		
		if (hostId == null) {
			UsersDTO newUser = new UsersDTO();
			newUser.setChatId(roomInfo.getChatId());
			newUser.setName(roomInfo.getUserName());
			hostId = usersService.createNewUser(newUser);
			room.setUserLogged(hostId);
		}
		
		//Otherwise let's just save the Room into the User
		else { 
			user.setChatId(roomInfo.getChatId());			
			room.setUserLogged(hostId);
		}
		
		pingRoomRepository.save(room);		
		return room.toString();
		
	}
	
	public PingRoom findRoom(long id) {		
		PingRoom pingRoom = pingRoomRepository.findById(id);	
		return pingRoom;		
	}
	

}
