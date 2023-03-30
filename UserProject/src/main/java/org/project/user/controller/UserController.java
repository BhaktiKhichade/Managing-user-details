package org.project.user.controller;

import java.util.List;

import org.project.user.model.User;
import org.project.user.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping(value = "userdatas")
public class UserController {
	
	private UserService userService;
	
	@GetMapping
	public List<User> getUserListCtrl()
	{
		System.out.println("dao controller");
		List<User> userList= userService.getUserListService();
		System.out.println("userList --"+userList);
		System.out.println("dao end");
		return userList;
		
	}
	@GetMapping("/{uname}")
	public User getUserByUserIdCtrl(@PathVariable(value="uname") int userid) {
		User user=userService.getUserByUserIdService(userid);
	    return user;
	}
	
	  @PostMapping public void insertUserCtrl(@RequestBody User user) {
	  userService.insertUserService(user); }
	  
	  @PutMapping public void updateUserctrl(@RequestBody User user) {
	  userService.updateUserService(user); }
	  
	  @DeleteMapping("/{uname}")
		public void deleteUserCtrl(@PathVariable(value = "uname") int userid)
		{
		  userService.deleteUserService(userid);
		}
	 
	}
