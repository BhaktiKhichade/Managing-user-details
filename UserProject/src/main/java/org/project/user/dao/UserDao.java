package org.project.user.dao;

import java.util.List;

import org.project.user.model.User;

public interface UserDao {

	List<User> getUserList();
    User getUserByUserId(int userid);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(int userid);
	



	



	

}
