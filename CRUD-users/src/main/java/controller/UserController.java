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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	/**
	 * Adds a new user to the database.
	 * A user must have a first name and last name. The id will be generated automatically and if not set, the security level will be 1.
	 * @param user
	 * @return
	 */
	@PostMapping("/newUser/")
	public ResponseEntity<?> addUser(@RequestBody User user ){
		if(user.getFirstname() =="") {
			return ResponseEntity.badRequest().body("No first name is set.");
		}else if(user.getLastname()=="") {
			return ResponseEntity.badRequest().body("No last name is set.");
		}
		int id = userservice.addUser(user);
		return ResponseEntity.ok().body("A new user has been added with information of "+
		user.getFirstname()+" "+user.getLastname()+" "+user.getEmail()+" "+user.getSecuritylevel()+" "+user.getUserid()+" with the id of "+id);
	}
	/**
	 * Returns the entire userbase ordered by ID
	 * @return a list of the entire userbase
	 */
	@GetMapping("/users")
	public ResponseEntity<?> list(){
		List<User> listUsers = userservice.list();
		return ResponseEntity.ok().body(listUsers);
	}
	/**
	 * update user id with user
	 * do no pass in new ID
	 * @param id
	 * @param user
	 * @return
	 */
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody User user){
		userservice.update(id, user);
		return ResponseEntity.ok().body("The user has been updated.");
	}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		userservice.delete(id);
		return ResponseEntity.ok().body("The user has been deleted.");
	}
	/**
	 * 
	 * @param id
	 * @return Ok response if id exists. If id is not in or request is not an integer, return bad.
	 */
	@GetMapping("/getUser/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") int id){
		User user = userservice.getUser(id);
		try {
			user.getFirstname();
		} catch (NullPointerException e) {
			return ResponseEntity.badRequest().body("Error, no user with id "+ id +".");
		}{
			return ResponseEntity.ok().body(user);
		}
	}
}
