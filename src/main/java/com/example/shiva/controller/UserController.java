package com.example.shiva.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shiva.models.User;
import com.example.shiva.service.UserService;
import com.example.shiva.util.JwtUtil;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	//Register API
	
	@PostMapping("/register")
	public Map<String, String> reister(@RequestBody User user){
		String message= service.register(user);
		Map<String,String> response=new HashMap<>();
		response.put("message", message);
		return response;
	}
	
	//Login API
	@PostMapping("/login")
	public Map<String,String> login(@RequestBody User user){
		Map<String, String> response =new HashMap<>();
		
		boolean valid = service.validateUser(user.getUsername(), user.getPassword());
		if(valid) {
			String token=jwtUtil.generateToken(user.getUsername());
			response.put("token", token);
			
		}
		else {
			response.put("error", "Invalid username or password");
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
//	
//	@PostMapping("/newuser")
//	public User newUser(@RequestBody User u) {
//		return service.addUser(u);
//	}
//	
//	@GetMapping
//	public List<User> allUsers(){
//		return service.getAllUsers();
//	}
//	
//	@GetMapping("/{id}")
//	public User singleUser(@PathVariable int id) {
//		return service.getSingleUser(id);
//	}
//	
//	@PutMapping("/changeuser")
//	public User changeUser(@RequestBody User u, @PathVariable int id) {
//		return service.updateUser(u, id);
//	}
//	
//	@DeleteMapping("/removeuser")
//	public String removeUser(@PathVariable int id) {
//		return service.deleteUser(id);
//	}
}
