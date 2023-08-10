package com.training.hibernateservlet.beans;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.training.hibernateservlet.model.HibernateManager;

public class Book {
	int bid;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	String bname;
	String author;
	int cost;
	String category;
	String status;
	public static ArrayList<Book> getAllBook() {
		ArrayList<Book> allBook = new ArrayList<Book>();
	    HibernateManager hbm = new HibernateManager();
	    Transaction trn = hbm.Session.beginTransaction();

	    Query allListQuery = hbm.Session.createQuery("FROM Book where status=:status");
	    allListQuery.setParameter("status","Active");
	    List list = allListQuery.list();
	    Iterator it = list.iterator();
	    while (it.hasNext()) {
	    	Book curBook = (Book) it.next();

	    	allBook.add(curBook);

	    }
	    trn.commit();
	    return allBook;
	}

}
