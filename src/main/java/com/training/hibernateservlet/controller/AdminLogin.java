package com.training.hibernateservlet.controller;

 

import java.io.IOException;

 

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

import com.training.hibernateservlet.beans.Admin;

import com.training.hibernateservlet.model.HibernateManager;

 

@WebServlet("/AdminLogin")

public class AdminLogin extends HttpServlet{

    public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{

        Admin ad=new Admin();

        int adminid=(Integer.parseInt(req.getParameter("admin_id")));

        String secretpin=(req.getParameter("secret_pin"));

        HttpSession session=req.getSession(true);

        HibernateManager hbm=new HibernateManager();

        boolean b=hbm.admin_login(adminid,secretpin);

        if(b==true) {

            session.setAttribute("admin_id",adminid);

            session.setAttribute("secretpin",secretpin);

            resp.sendRedirect("AdminHomePage.jsp");

        }

        else {

            resp.sendRedirect("AdminLoginFail.html");

        }

        

    }

 

}