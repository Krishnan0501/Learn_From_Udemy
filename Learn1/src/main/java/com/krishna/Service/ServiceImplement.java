package com.krishna.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.Entity.User;
import com.krishna.repository.Connectivity;

@Service
public class ServiceImplement implements ServiceInterface {

    @Autowired
    private Connectivity repository;

   
    public List<User> fetchuser() {
        return repository.findAll();
    }
    public User fetchuserpath(int id) {
        return repository.findById(id).orElse(null);
    }

    public User addingUser(User userdetail) {
        return repository.save(userdetail);
    }

 
    public void deleteUser(int id) {
        repository.deleteById(id);
    }
	
	
}
