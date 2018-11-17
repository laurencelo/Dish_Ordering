package model;

public class User {
	private int userId;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
}
