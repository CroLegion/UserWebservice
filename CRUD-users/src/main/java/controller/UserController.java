package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/user")
	public ResponseEntity<?> list(@RequestBody User user){
		List<User> listUsers = userservice.list();
		return ResponseEntity.ok().body(listUsers);
	}
	@PutMapping("/user{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, User user){
		userservice.update(id, user);
		return ResponseEntity.ok().body("The user has been updated.");
	}
	@DeleteMapping("/user{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		userservice.delete(id);
		return ResponseEntity.ok().body("The user has been deleted");
	}
	@GetMapping("/user{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int id){
		User user = userservice.getUser(id);
		return ResponseEntity.ok().body(user);
	}
}
