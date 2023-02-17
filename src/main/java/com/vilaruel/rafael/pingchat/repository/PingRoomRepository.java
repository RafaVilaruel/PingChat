package com.vilaruel.rafael.pingchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vilaruel.rafael.pingchat.model.PingRoom;

public interface PingRoomRepository extends JpaRepository<PingRoom, Long>{

	PingRoom findById(long id);
	
}
