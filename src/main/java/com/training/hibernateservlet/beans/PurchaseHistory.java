package com.training.hibernateservlet.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.training.hibernateservlet.model.HibernateManager;

public class PurchaseHistory {
int pid;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
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
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getInvoice_no() {
	return invoice_no;
}
public void setInvoice_no(int invoice_no) {
	this.invoice_no = invoice_no;
}
int bid;
String bname;
int uid;
int amount;
int invoice_no;

public static ArrayList<PurchaseHistory> getAllPurchaseHistroy() {

	ArrayList<PurchaseHistory> allpurchases = new ArrayList<PurchaseHistory>();

	HibernateManager hbm = new HibernateManager();

	Query allListQuery = HibernateManager.Session.createQuery("FROM PurchaseHistory");

	List list = allListQuery.list();

	Iterator it = list.iterator();

	while (it.hasNext()) {

		PurchaseHistory curpurchase = (PurchaseHistory) it.next();

		allpurchases.add(curpurchase);

	}

	return allpurchases;

}
public static ArrayList<PurchaseHistory> getAllPurchasesw() {
	ArrayList<PurchaseHistory> allPurchases = new ArrayList<PurchaseHistory>();
    HibernateManager hbm = new HibernateManager();
    Transaction trn = hbm.Session.beginTransaction();

    Query allListQuery = hbm.Session.createQuery("FROM purchasehistory where status=:status");
    allListQuery.setParameter("status","Active");
    List list = allListQuery.list();

    Iterator it = list.iterator();

    while (it.hasNext()) {

    	PurchaseHistory curPur = (PurchaseHistory) it.next();

    	allPurchases.add(curPur);

    }
    trn.commit();
    return allPurchases;
}


}
