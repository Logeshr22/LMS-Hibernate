package com.training.hibernateservlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		int uid=(Integer.parseInt(req.getParameter("uid")));
		HibernateManager hbm=new HibernateManager();
		boolean b=hbm.deleteUser(uid);
		if(b==true)
		{
			resp.sendRedirect("DeleteSuccess.html");
		}
		else
		{
			resp.sendRedirect("DeleteFail.html");
		}
		
	}
	

}
