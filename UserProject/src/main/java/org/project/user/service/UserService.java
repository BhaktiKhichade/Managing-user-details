package org.project.user.service;

import java.util.List;

import org.project.user.model.User;

public interface UserService {
   List<User> getUserListService();
   User getUserByUserIdService(int userid);
	
	  void insertUserService(User user); 
	  void updateUserService(User user);
	void deleteUserService(int userid);
	 
}
