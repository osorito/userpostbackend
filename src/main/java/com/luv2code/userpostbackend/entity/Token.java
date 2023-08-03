package com.luv2code.userpostbackend.entity;

public class Token {
	private String token;
	private String expiresIn;
	private String userId;
	
	public Token()
	{
		
	}

	public Token(String token, String expiresIn, String userId) {
		this.token = token;
		this.expiresIn = expiresIn;
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", expiresIn=" + expiresIn + ", userId=" + userId + "]";
	}
	
	
	
}
