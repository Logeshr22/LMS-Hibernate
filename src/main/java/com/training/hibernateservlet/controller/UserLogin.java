package com.training.hibernateservlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.hibernateservlet.beans.User;
import com.training.hibernateservlet.model.HibernateManager;
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		User u=new User();
		int uid=Integer.parseInt(req.getParameter("uid"));
		String pwd=(req.getParameter("pwd"));
		HttpSession session=req.getSession(true);
		HibernateManager hbm=new HibernateManager();
		boolean b=hbm.user_login(uid,pwd);
	    if(b==true) {
	    	session.setAttribute("uid",uid);
	    	session.setAttribute("secretpin",pwd);
	    	resp.sendRedirect("UserHomePage.jsp");
	    }
	    else {
	    	resp.sendRedirect("UserLoginFail.html");
	    }
		
	}

}
