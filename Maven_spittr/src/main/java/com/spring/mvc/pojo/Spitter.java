package com.spring.mvc.pojo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

public class Spitter {
	private Integer id;
	@NotNull
	@Size(max=20,min=4,message="{firstName.message}")
	private String firstName;
	@NotNull
	@Size(max=20,min=4,message="{lastName.message}")
	private String lastName;
	@NotNull
	@Size(max=20,min=4,message="{email.message}")
	private String email;
	@NotNull
	@Size(max=20,min=4,message="{username.message}")
	private String username;
	@NotNull
	@Size(max=20,min=4,message="{password.message}")
	private String password;
	private String loc_img;
	/**
	 * Constructor with no parameters
	 */
	public Spitter() {
		super();
	}
	@Override
	public String toString() {
		return "Spitter [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", loc_img=" + loc_img + "]";
	}
	/**
	 * set/get method
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	@Autowired
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	@Autowired
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	@Autowired
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Autowired
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	@Autowired
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	@Autowired
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoc_img() {
		return loc_img;
	}
	@Autowired
	public void setLoc_img(String loc_img) {
		this.loc_img = loc_img;
	}
}
