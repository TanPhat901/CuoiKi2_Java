package model;

import java.io.Serializable;

public class ModelUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Username;
	private String Password;
	private String FullName;
	private String Email;
	private String Phone;
	private String Address;
	public ModelUserLogin(String username, String password, String fullName, String email, String phone,
			String address) {
		super();
		Username = username;
		Password = password;
		FullName = fullName;
		Email = email;
		Phone = phone;
		Address = address;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
}
