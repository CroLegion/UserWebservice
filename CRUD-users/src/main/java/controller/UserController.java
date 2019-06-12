package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User user){
		int id = userservice.addUser(user);
		return ResponseEntity.ok().body("A new user has been added by the name of"+
		user.getFirstName()+" "+user.getLastName()+" with the id of "+id);
	}
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user){
		int id = userservice.save(user);
	}
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user){
		int id = userservice.save(user);
	}
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user){
		int id = userservice.save(user);
	}
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody User user){
		int id = userservice.save(user);
	}
}
