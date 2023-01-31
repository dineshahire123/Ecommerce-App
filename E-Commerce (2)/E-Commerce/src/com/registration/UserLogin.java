package com.registration;

public class UserLogin {
	private int uid;
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	private String email;
	private String pass;

	
	@Override
	public String toString() {
		return "UserLogin [uid=" + uid + ", email=" + email + ", pass=" + pass + "]";
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
