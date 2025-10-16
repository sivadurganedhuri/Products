package com.example.shiva.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shiva.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);

	void save(Map<String, User> users);
}
