package com.yvan.users.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yvan.users.entities.User;
import com.yvan.users.repos.UserRepository;
import com.yvan.users.service.UserService;
import com.yvan.users.service.register.RegistrationRequest;

@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;


	// @RequestMapping(path="all", method = RequestMethod.GET)
	@GetMapping("all")
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}

	@PostMapping("/register")
	public User register(@RequestBody RegistrationRequest request) {
		return userService.registerUser(request);
	}

	@GetMapping("/verifyEmail/{token}")
	public User verifyEmail(@PathVariable("token") String token){
		return userService.validateToken(token);
	}

}
