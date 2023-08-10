package com.training.hibernateservlet.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.training.hibernateservlet.beans.Admin;
import com.training.hibernateservlet.beans.Book;
import com.training.hibernateservlet.beans.PurchaseHistory;
import com.training.hibernateservlet.beans.Subscription;
import com.training.hibernateservlet.beans.User;

public class HibernateManager {

	public static Session Session;

	public HibernateManager() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());
		Session = sessionFactory.openSession();
		System.out.println("Connected to pf...");

	}

	public boolean update(int bid) {

		Transaction transaction = Session.beginTransaction();
		Book b = (Book) Session.get(Book.class, bid);
		b.setStatus("Inactive");
		Session.update(b);
		System.out.println("Update Success");
		transaction.commit();
		return true;

	}

	public boolean admin_login(int admin_id, String secretpin) {

		Transaction transaction = Session.beginTransaction();

		Admin a = (Admin) Session.get(Admin.class, admin_id);

		if (a != null)

		{

			transaction.commit();

			return true;

		}

		return false;

	}
	public boolean user_login(int uid,String pwd)
	{
		Transaction transaction=Session.beginTransaction();
		Query query=Session.createQuery("from User where uid=:uid and pwd=:pwd");
		query.setParameter("uid",uid);
		query.setParameter("pwd",pwd);
		if(query!=null)
		{
			transaction.commit();
			return true;
		}
		
		return false;
	}
	
	public boolean deleteUser(int uid)
	{
		Transaction transaction=Session.beginTransaction();
		User u=(User)Session.get(User.class,uid);
		u.setStatus("Inactive");
		Session.update(u);
		transaction.commit();
		return true;
	}



	public static ArrayList<Subscription> readAll()

	{
		ArrayList<Subscription> allSubscriptions = new ArrayList<Subscription>();
		Transaction tran = Session.beginTransaction();

		org.hibernate.Query q = Session.createQuery("From Subscription");

		List l1 = q.list();

		Iterator itr = l1.iterator();

		Subscription s = null;

		while (itr.hasNext())

		{

			Subscription curSub = (Subscription) itr.next();

			allSubscriptions.add(curSub);

		}
		tran.commit();

		return allSubscriptions;
	}

	public static ArrayList<Book> readAllBook()

	{
		ArrayList<Book> allBooks = new ArrayList<Book>();
		Transaction tran = Session.beginTransaction();

		org.hibernate.Query q = Session.createQuery("From Book where status=:status");
		q.setParameter("status","Active");

		List l1 = q.list();

		Iterator itr = l1.iterator();

		Subscription s = null;

		while (itr.hasNext())

		{

			Book curSub = (Book) itr.next();

			allBooks.add(curSub);

		}
		tran.commit();
		return allBooks;

	}

	public static ArrayList<User> readAllUser()

	{
		ArrayList<User> allUser = new ArrayList<User>();
		Transaction tran = Session.beginTransaction();

		org.hibernate.Query q = Session.createQuery("From User where status=:status");
		q.setParameter("status","Inactive");
		List l1 = q.list();

		Iterator itr = l1.iterator();

		User u = null;

		while (itr.hasNext())

		{

			User curSub = (User) itr.next();

			allUser.add(curSub);

		}
		tran.commit();
		return allUser;

	}

	public boolean authorizebook(int bid) {
		Transaction tran = Session.beginTransaction();
		Book b = (Book) Session.get(Book.class, bid);
		b.setStatus("Active");
		Session.update(b);
		// System.out.println("Update Success");
		tran.commit();
		return true;
	}

	public boolean authorizeuser(int uid) {
		Transaction tran = Session.beginTransaction();
		User u = (User) Session.get(User.class, uid);
		u.setStatus("Active");
		Session.update(u);
		// System.out.println("Update Success");
		tran.commit();
		return true;
	}
	public boolean AddBook(Book b) {
		Transaction tran=Session.beginTransaction();
		Session.save(b);
		tran.commit();
		System.out.println("Object saved");
		return true;
	}
	public boolean AddPurchase(PurchaseHistory p) {
		Transaction tran=Session.beginTransaction();
		Session.save(p);
		tran.commit();
		System.out.println("Object saved");
		return true;
	}
	public boolean AddSubscription(Subscription s) {

        Transaction tran=Session.beginTransaction();

        Session.save(s);

        tran.commit();

        System.out.println("Object saved");

        return true;

    }
	public void saveObj(User a1)

    {
        Transaction tran = Session.beginTransaction();

        Session.save(a1);

        tran.commit();

        System.out.println("object saved");
    }
}