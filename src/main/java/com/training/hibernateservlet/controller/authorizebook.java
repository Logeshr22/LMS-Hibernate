package com.training.hibernateservlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.hibernateservlet.beans.Book;
import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/authorizebooks")
public class authorizebook extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bid=Integer.parseInt(req.getParameter("bid"));
		
		Book b=new Book();
		b.setBid(bid);
		HibernateManager hb= new HibernateManager();
		if(hb.authorizebook(bid)==true) {
			
			resp.sendRedirect("/LMS-Hibernate/UpdateSuccess.html");
		}
		else {
			resp.sendRedirect("/LMS-Hibernate/UpdateFailed.html");
			
		}

	}
	}

