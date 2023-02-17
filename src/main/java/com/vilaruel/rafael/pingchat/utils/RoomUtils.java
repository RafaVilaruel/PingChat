package com.vilaruel.rafael.pingchat.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.vilaruel.rafael.pingchat.dto.PingRoomDTO;
import com.vilaruel.rafael.pingchat.model.PingRoom;

@Component
public class RoomUtils {	

	public Boolean validateLogin(PingRoom room, PingRoomDTO roomInfo) {
		Boolean isValidated = Boolean.FALSE;
		try {
			if (room.getChatPassword().toString().equals(roomInfo.getChatPassword())				
				&& room.getUserLogged() == null) {
				isValidated = Boolean.TRUE;	
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isValidated = Boolean.FALSE;
			return isValidated;
		}
		return isValidated;
		
	
}

}