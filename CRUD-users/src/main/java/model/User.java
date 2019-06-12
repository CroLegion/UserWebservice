package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	private String FirstName;
	
	private String LastName;
	
	private String Email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int UserID;
	
	private int Securitylevel;
	
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public int getSecuritylevel() {
		return Securitylevel;
	}
	public void setSecuritylevel(int securitylevel) {
		Securitylevel = securitylevel;
	}
}
