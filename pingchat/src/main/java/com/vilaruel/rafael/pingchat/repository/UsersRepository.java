package com.vilaruel.rafael.pingchat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vilaruel.rafael.pingchat.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

	Users findById(long id);
}
