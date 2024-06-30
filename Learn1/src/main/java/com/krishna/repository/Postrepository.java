package com.krishna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.krishna.Entity.Post;
import com.krishna.Entity.User;
@Repository
public interface Postrepository extends JpaRepository<Post, Integer> {


	List<Post> save(User user);

}
