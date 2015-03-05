package com.coolrandy.domin;

import java.io.Serializable;

public class PwdAccount implements Serializable{
	
	private int id;
	private String password;
	private String username;
	
	public PwdAccount(int id, String password, String username) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
	}
	public PwdAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PwdAccount [id=" + id + ", password=" + password
				+ ", username=" + username + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
}
