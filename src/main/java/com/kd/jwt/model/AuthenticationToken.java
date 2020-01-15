package com.kd.jwt.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationToken extends UsernamePasswordAuthenticationToken{
	
	private static final long serialVersionUID = 1L;

	private String token;
	
	public AuthenticationToken(String token) {
		super(null, null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
//		return super.getCredentials();
		return null;
	}
	
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
//		return super.getPrincipal();
		return null;
	}
}
