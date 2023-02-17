package com.vilaruel.rafael.pingchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vilaruel.rafael.pingchat.model.Messages;

public interface MessagesRepository extends JpaRepository<Messages, Long>{

	Messages findById(long id);
}
