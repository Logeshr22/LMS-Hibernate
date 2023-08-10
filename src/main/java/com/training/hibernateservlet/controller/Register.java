package com.training.hibernateservlet.controller;

 

import java.io.IOException;

 

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

 

import com.training.hibernateservlet.beans.User;

import com.training.hibernateservlet.model.HibernateManager;

 

@WebServlet("/signup")

public class Register extends HttpServlet{

    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User usr = new User();

        usr.setUid(Integer.parseInt(req.getParameter("uid")));

        usr.setUname(req.getParameter("uname"));

        usr.setPwd(req.getParameter("pwd"));

        usr.setAddress(req.getParameter("add"));

        usr.setPhone(Long.parseLong(req.getParameter("phone")));

        usr.setEmail(req.getParameter("email"));

        usr.setStatus("inactive");

        HibernateManager hbm = new HibernateManager();

        hbm.saveObj(usr);

    }

}