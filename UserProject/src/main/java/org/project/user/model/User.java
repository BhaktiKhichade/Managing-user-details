package org.project.user.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int userid;
	private String userName;
	private String email;
	private int roleId;
	private String mobileNo;
	private String pass;
	private String hintQuestion;
	private String answer;
	private String status;
	
}
