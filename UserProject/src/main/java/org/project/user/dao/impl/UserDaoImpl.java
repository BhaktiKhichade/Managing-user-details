package org.project.user.dao.impl;

import java.util.List;

import org.project.user.dao.UserDao;
import org.project.user.dao.extractor.UserExtractor;
import org.project.user.dao.extractor.UserListExtractor;
import org.project.user.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;
	private UserListExtractor userListExtractor;
	private UserExtractor userExtractor;

	@Override
	public List<User> getUserList() {
		System.out.println("d");
		List<User> userList = jdbcTemplate.query("select * from userdata order by userid",
				userListExtractor::extractData);
		///List<User> userList = jdbcTemplate.query("select * from users order by userid",
				//userListExtractor::extractData);

		System.out.println("--d");
		return userList;
	}

	@Override
	public User getUserByUserId(int userid) {
		User user = jdbcTemplate.query("select * from userdata where userid=" + userid, userExtractor::extractData);
		//User user = jdbcTemplate.query("select * from users where userid=" + userid, userExtractor::extractData);
		return user;
	}

		@Override
	public void insertUser(User user) {
		String query= "insert into userdata values("+user.getUserid()+",'"+user.getUserName()+"','"+user.getEmail()+"',"+user.getRoleId()+",'"+user.getMobileNo()+"','"+user.getPass()+"','"+user.getHintQuestion()+"','"+user.getAnswer()+"','"+user.getStatus()+"')";
			//String query= "insert into users values("+user.getUserid()+",'"+user.getUserName()+"','"+user.getEmail()+"',"+user.getRoleId()+",'"+user.getMobileNo()+"','"+user.getPass()+"','"+user.getHintQuestion()+"','"+user.getAnswer()+"','"+user.getStatus()+"')";
			jdbcTemplate.update(query);
		
	}

	
	 @Override public void updateUser(User user) { 
		String  query="Update userdata set userName='"+user.getUserName()+"where userid="+user.getUserid(); jdbcTemplate.update(query);
		// String  query="Update users set userName='"+user.getUserName()+"where userid="+user.getUserid(); jdbcTemplate.update(query);
	     jdbcTemplate.update(query);
	  }
	  
	 @Override
		public void deleteUser(int userid) {
			String query="delete from userdata where userid="+userid ;
		 //String query="delete from users where userid="+userid ;
			jdbcTemplate.update(query);
			
			
		} 
	 
}
