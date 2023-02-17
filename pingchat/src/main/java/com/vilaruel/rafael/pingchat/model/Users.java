package com.vilaruel.rafael.pingchat.model;

import java.io.Serializable;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Component
@Table(name = "user_info")
public class Users implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "user_id")
	private Long userId;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "name", nullable = true, length = 50)	
	private String name; 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chat_id", nullable = false, length = 50)	
	private Long chatId;    

}
