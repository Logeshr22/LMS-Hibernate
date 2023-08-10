package com.training.hibernateservlet.beans;




import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.hibernateservlet.model.HibernateManager;

public class User {
	int uid;
	String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String pwd;
	String address;
	long phone;
	String email;
	String status;
	
	public static ArrayList<User> getAllUsers() {

		ArrayList<User> allusers = new ArrayList<User>();

		HibernateManager hbm = new HibernateManager();
		
		Transaction tran = hbm.Session.beginTransaction();


		Query allListQuery = hbm.Session.createQuery("From User where status=:status");
		allListQuery.setParameter("status","Active");

		List list = allListQuery.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			User curuser = (User) it.next();

			allusers.add(curuser);

		}

		return allusers;

	}
}
