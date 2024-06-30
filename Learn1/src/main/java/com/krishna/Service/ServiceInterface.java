package com.krishna.Service;

import java.util.List;

import com.krishna.Entity.Post;
import com.krishna.Entity.User;

public interface ServiceInterface {

		public List<User> fetchuser() ;
		public User fetchuserpath(int id) ;
		public User addingUser(User userdetail) ;
		public void deleteUser(int id);
	}


