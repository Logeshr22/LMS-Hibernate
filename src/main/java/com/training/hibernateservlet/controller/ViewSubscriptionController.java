package com.training.hibernateservlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.training.hibernateservlet.beans.Subscription;

import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/view")

public class ViewSubscriptionController extends HttpServlet {

	@Override

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HibernateManager hbm = new HibernateManager();

		HttpSession session = req.getSession(true);

		ArrayList<Subscription> allSubscriptions = hbm.readAll();

		resp.sendRedirect("/LMS-Hibernate/viewAllSubscription.jsp");

	}

}
