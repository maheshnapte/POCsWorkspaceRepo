package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		/*
		 * Employee e1 = new Employee(); e1.setId(115); e1.setFirstName("Gaurav");
		 * e1.setLastName("Kawala"); session.save(e1);
		 * 
		 * Employee e2 = new Employee(); e2.setId(116); e2.setFirstName("Gaurav");
		 * e2.setLastName("Kawala");
		 * 
		 * session.save(e2);
		 */

		Employee e = session.get(Employee.class, 102);
		System.out.println("Employee: " + e);

		e.setFirstName("Mahesh");
		Employee e11 = session.get(Employee.class, 102);
		System.out.println("Employee: " + e11);

	//	t.commit();

		Company c = new Company();
		c.setcId(1);
		c.setcName("TIAA GBS");
		c.setcAddress("Pune");
		session.save(c);
		t.commit();
		System.out.println("successfully saved");
		factory.close();

		session.close();

	}
}