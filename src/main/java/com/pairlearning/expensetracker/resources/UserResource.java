package com.pairlearning.expensetracker.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pairlearning.expensetracker.domain.User;
import com.pairlearning.expensetracker.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String, Object> userMap){
	
		String email = (String)userMap.get("email");
		String password = (String)userMap.get("password");
		User user = userService.validateUser(email, password);
		Map<String,String> map = new HashMap<>();
		map.put("message", "loggedIn sucessfully");
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap) {
		
		String firstName=(String)userMap.get("firstName");
		String lastName = (String)userMap.get("lastName");
		String email = (String)userMap.get("email");
		String password = (String)userMap.get("password");
		
	User user = userService.registerUser(firstName, lastName, email, password);
	Map<String,String> map = new HashMap<>();
	map.put("message", "registered sucessfully");
	
	return new ResponseEntity<>(map, HttpStatus.OK);
	
	}
}
