package com.training.hibernateservlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.hibernateservlet.beans.User;
import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/authorizeuser")
public class authorizeuser extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid=Integer.parseInt(req.getParameter("uid"));
		User u= new User();
		u.setUid(uid);
		HibernateManager hb= new HibernateManager();
		if(hb.authorizeuser(uid)==true) {
			
			resp.sendRedirect("/LMS-Hibernate/UpdateSuccess.html");
		}
		else {
			resp.sendRedirect("/LMS-Hibernate/UpdateFailed.html");
			
		}

	}
	}

