package org.project.user.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.project.user.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;



@Component
public class UserListExtractor  implements ResultSetExtractor <List<User>>{

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		ArrayList<User> userList= new ArrayList<User>();
		User user=null;
		
		while(rs.next()) {
			
			user=new User();
			user.setUserid(rs.getInt("userid"));
			user.setUserName(rs.getString("userName"));
			user.setEmail(rs.getString("email"));
			user.setRoleId(rs.getInt("roleId"));
			user.setMobileNo(rs.getString("mobileNo"));
			user.setPass(rs.getString("pass"));
			user.setHintQuestion(rs.getString("hintQuestion"));
			user.setAnswer(rs.getString("answer"));
			user.setStatus(rs.getString("status"));
			
			userList.add(user);
		}
		return userList;
	}

}
