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
@Table(name = "ping_rooms")
public class PingRoom implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "chat_id")
	private Long chat_id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "url_song_being_played", nullable = true, length = 50)	
	private String urlSongBeingPlayed; 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chat_password", nullable = false, length = 50)	
	private String chatPassword;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_host", nullable = false, length = 50)	
	private Long userHost; 
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_logged", nullable = true, length = 50)	
	private Long userLogged; 

}
