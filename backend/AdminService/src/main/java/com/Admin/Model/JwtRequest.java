package com.Admin.Model;

public class JwtRequest {

    private String username;
    private String Password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "JwtRequest [username=" + username + ", Password=" + Password + "]";
	}
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}
	public JwtRequest() {
		super();
	}
    
    
    
    
    
}