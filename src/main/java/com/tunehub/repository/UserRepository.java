package com.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	public Users findByEmail(String email) ;
	
}
