package com.training.hibernateservlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.training.hibernateservlet.beans.Book;
import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book b=new Book();
		HttpSession session=req.getSession(true);
		b.setBname(req.getParameter("bname"));
		b.setAuthor(req.getParameter("author"));
		b.setCost(Integer.parseInt(req.getParameter("cost")));
		b.setCategory(req.getParameter("category"));
		b.setStatus(req.getParameter("status"));
		HibernateManager hb=new HibernateManager();
		if(hb.AddBook(b)) {
			session.setAttribute("bid",b.getBid());
			session.setAttribute("bname",b.getBname());
			session.setAttribute("author",b.getAuthor());
			session.setAttribute("cost",b.getCost());
			session.setAttribute("category",b.getCategory());
			session.setAttribute("status",b.getStatus());
			resp.sendRedirect("/LMS-Hibernate/AddBookSuccess.html");
		}
		else {
			resp.sendRedirect("/LMS-Hibernate/AddBookFail.html");
		}
	}
}

