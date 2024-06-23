package model;

public class ModelAdminLogin {
	private String User;
	private String Password;
	public ModelAdminLogin(String user, String password) {
		super();
		User = user;
		Password = password;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
