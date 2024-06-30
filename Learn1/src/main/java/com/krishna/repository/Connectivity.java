package com.krishna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishna.Entity.User;

@Repository
public interface Connectivity extends JpaRepository<User, Integer> {

	User save(User user);
	
	void deleteById(int id);

	User findByid(int id);

}
