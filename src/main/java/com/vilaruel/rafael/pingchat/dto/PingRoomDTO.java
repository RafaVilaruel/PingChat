package com.vilaruel.rafael.pingchat.dto;

import lombok.Data;

@Data
public class PingRoomDTO {

	private Long chatId;
	private Long userId;
	private String userName;
	private String urlSongBeingPlayed; 
	private String chatPassword;    

}
