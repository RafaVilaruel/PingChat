package com.vilaruel.rafael.pingchat.dto;

import lombok.Data;

@Data
public class PingRoomResponseDTO {

	private Long chatId;
	private Long userId;
	private Boolean previousRoomDeleted; 

}
