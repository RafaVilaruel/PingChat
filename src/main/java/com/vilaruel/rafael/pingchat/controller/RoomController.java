package com.vilaruel.rafael.pingchat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilaruel.rafael.pingchat.dto.PingRoomDTO;
import com.vilaruel.rafael.pingchat.dto.PingRoomResponseDTO;
import com.vilaruel.rafael.pingchat.model.PingRoom;
import com.vilaruel.rafael.pingchat.model.Users;
import com.vilaruel.rafael.pingchat.repository.PingRoomRepository;
import com.vilaruel.rafael.pingchat.service.RoomService;
import com.vilaruel.rafael.pingchat.service.UsersService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/pingchat")
@RequiredArgsConstructor
public class RoomController {
	
	//Repositories
	private final PingRoomRepository pingRoomRepository;
	private final RoomService roomService;
	private final UsersService usersService;
		
	/*
	 * @GetMapping("/playerInfo") public List<PlayerInfoDTO> playerList(){ return
	 * playerInfo.findAll(); }
	 */
	
    @PostMapping("/create") 
    public ResponseEntity<PingRoomResponseDTO> pingRoomCreate(@RequestBody PingRoomDTO request){ 
    	 
    	PingRoomResponseDTO response = roomService.createNewRoom(request);    	
    	return ResponseEntity.ok().body(response);	  
	  
	  }
    
    @PostMapping("/login") 
    public ResponseEntity<String> pingRoomLogin(@RequestBody PingRoomDTO request){ 
    	 
    	String response = roomService.loginRoom(request);    	
    	return ResponseEntity.ok().body(response);	  
	  
	  }
    
    @PostMapping("/delete") 
    public ResponseEntity<String> pingRoomDelete(@RequestBody PingRoomDTO request){ 
    	 
    	try {  		
			pingRoomRepository.deleteById(request.getChatId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}	 
    	return ResponseEntity.ok().body("The chat has been deleted.");	  
	  
	  }
     
  
	 
	
}
