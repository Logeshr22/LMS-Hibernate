package com.training.hibernateservlet.beans;

 

import java.util.Date;

 

public class Subscription {

int sub_id;

public int getSub_id() {

    return sub_id;

}

public void setSub_id(int sub_id) {

    this.sub_id = sub_id;

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

public int getInvoiceno() {

    return invoiceno;

}

public void setInvoiceno(int invoiceno) {

    this.invoiceno = invoiceno;

}

public String getDate() {

    return date;

}

public void setDate(String date) {

    this.date = date;

}

int uid;

int amount;

int invoiceno;

String date;

 

}																						