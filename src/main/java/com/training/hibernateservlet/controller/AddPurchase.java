package com.training.hibernateservlet.controller;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.training.hibernateservlet.beans.PurchaseHistory;
import com.training.hibernateservlet.model.HibernateManager;

@WebServlet("/AddPurchase")
public class AddPurchase extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PurchaseHistory p=new PurchaseHistory();
		HttpSession session=req.getSession();
		p.setBid(Integer.parseInt(req.getParameter("bid")));
		p.setBname(req.getParameter("bname"));
		p.setUid((int)(session.getAttribute("uid")));
		p.setAmount(Integer.parseInt(req.getParameter("amount")));
		int id=ThreadLocalRandom.current().nextInt(1,100000);
		p.setInvoice_no(id);
		HibernateManager hb=new HibernateManager();
		if(hb.AddPurchase(p)) {
			session.setAttribute("bid",p.getBid());
			session.setAttribute("bname",p.getBname());
			session.setAttribute("uid",p.getUid());
			session.setAttribute("amount",p.getAmount());
			session.setAttribute("invoice_no",p.getInvoice_no());
			resp.sendRedirect("/LMS-Hibernate/AddPurchaseSuccess.html");
		}
		else {
			resp.sendRedirect("/LMS-Hibernate/AddPurchaseFail.html");
		}
	}
}


