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
	
	@PostMapping("/newUser/")
	public ResponseEntity<?> addUser(@RequestBody User user ){
		int id = userservice.addUser(user);
		return ResponseEntity.ok().body("A new user has been added by the name of"+
		user.getFirstname()+" "+user.getLastname()+" with the id of "+id);
	}
	@GetMapping("/users")
	public ResponseEntity<?> list(){
		List<User> listUsers = userservice.list();
		return ResponseEntity.ok().body(listUsers);
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody User user){
		userservice.update(id, user);
		return ResponseEntity.ok().body("The user has been updated.");
	}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		userservice.delete(id);
		return ResponseEntity.ok().body("The user has been deleted");
	}
	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int id){
		User user = userservice.getUser(id);
		try {
			user.getFirstname();
		} catch (NullPointerException e) {
			return ResponseEntity.ok("Error, no user with id "+ id);
		}{
			return ResponseEntity.ok().body(user);
		}
	}
}
