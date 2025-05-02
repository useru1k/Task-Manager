package model;

public class User {
	
	private int user_id;
	private String userName;
	private String passwordHash;
	private String role;
	
	User(int id,String name,String password) {
		this.user_id = id;
		this.userName = name;
		this.passwordHash = password;
	}
	
	public void setId(int id) {
		this.user_id = id;
	}
	
	public void setUsername(String name) {
		this.userName = name;
	}
	
	public void setPassword(String pass) {
		this.passwordHash = pass;
	}
}
