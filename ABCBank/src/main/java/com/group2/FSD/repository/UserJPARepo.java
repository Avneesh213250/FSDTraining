package com.group2.FSD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.FSD.domain.User;

public interface UserJPARepo extends JpaRepository<User, Integer>{
	
	
}
