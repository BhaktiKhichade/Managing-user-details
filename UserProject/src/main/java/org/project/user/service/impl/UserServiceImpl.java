package org.project.user.service.impl;

import java.util.List;

import org.project.user.dao.UserDao;
import org.project.user.model.User;
import org.project.user.service.UserService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService{
  private UserDao userDao;
	@Override
	public List<User> getUserListService() {
		List<User> userList= userDao.getUserList();
		return userList;
	}
	@Override
	public User getUserByUserIdService(int userid) {
		User user=userDao.getUserByUserId(userid);
		return user;
	}
	
	  @Override public void insertUserService(User user) {
	  userDao.insertUser(user);
	  
	  }
	  
	  @Override public void updateUserService(User user) {
	  userDao.updateUser(user);
	  
	  }
	@Override
	public void deleteUserService(int userid) {
		userDao.deleteUser(userid);
		
	}
	 
	

}
