package com.training.hibernateservlet.controller;

 

import java.io.IOException;

import java.time.LocalDate;

import java.util.Date;

import java.util.concurrent.ThreadLocalRandom;

 

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import com.training.hibernateservlet.beans.Subscription;

import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/AddSubscription")

public class AddSubscription extends HttpServlet {

    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Subscription s=new Subscription();

        HttpSession session=req.getSession();

        s.setUid((int) session.getAttribute("uid"));

        s.setAmount(Integer.parseInt(req.getParameter("amount")));

        int id=ThreadLocalRandom.current().nextInt(1,100000);

        s.setInvoiceno(id);

        String date=req.getParameter("date");

        s.setDate(date);

        HibernateManager hb=new HibernateManager();

        if(hb.AddSubscription(s)) {

            session.setAttribute("sub_id",s.getSub_id());

            session.setAttribute("uid",s.getUid());

            session.setAttribute("amount",s.getAmount());

            session.setAttribute("invoiceno",s.getInvoiceno());

            session.setAttribute("date",date);

            resp.sendRedirect("/LMS-Hibernate/AddPurchaseSuccess.html");

        }

        else {

            resp.sendRedirect("/LMS-Hibernate/AddPurchaseFail.html");

        }

    }

}

 