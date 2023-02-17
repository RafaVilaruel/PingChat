package com.vilaruel.rafael.pingchat.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MessagesDTO {
		
	private Long chatId;
	private String content; 
	private String sentAt; 
	private Long userId;

}
