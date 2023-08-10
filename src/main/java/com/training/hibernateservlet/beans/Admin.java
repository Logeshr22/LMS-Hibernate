package com.training.hibernateservlet.beans;

public class Admin {
	int admin_id;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getSecretpin() {
		return secretpin;
	}
	public void setSecretpin(String secretpin) {
		this.secretpin = secretpin;
	}
	String secretpin;
}
	