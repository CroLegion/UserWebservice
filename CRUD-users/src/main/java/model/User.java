package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jstil
 * 
 */
@Entity
@Table(name = "users")
public class User {
	/*
	 * first name of a user
	 */
	private String firstname;
	/*
	 * last name of a user
	 */
	private String lastname;
	/*
	 * email of user
	 */
	private String email;
	/*
	 * ID number of user set up to be created on user creation 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	/*
	 * security level of user set from 1-5 with 1 being lowest and 5 being highest
	 */
	private int securitylevel;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getSecuritylevel() {
		return securitylevel;
	}

	public void setSecuritylevel(int securitylevel) {
		this.securitylevel = securitylevel;
	}
}