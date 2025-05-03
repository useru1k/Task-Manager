package model;

public class User {
	
	private int user_id;
	private String userName;
	private String passwordHash;
	private String role;
	
	public User(int user_id,String userName,String password,String role) {
		this.user_id = user_id;
		this.userName = userName;
		this.passwordHash = password;
		this.role = role;
	}
	
	public void setId(int user_id) {
		this.user_id = user_id;
	}
	
	public void setUsername(String name) {
		this.userName = name;
	}
	
	public void setPassword(String pass) {
		this.passwordHash = pass;
	}
	
	public int getId() {
		return user_id;
	}
	
	public String getUsername() {
		return userName;
	}
	
	public String getPassword() {
		return passwordHash;
	}
	
	public String getRole() {
		return role;
	}
}
