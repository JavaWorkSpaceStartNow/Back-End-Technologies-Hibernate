package C_Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_Entity.A_Student;

public class A_Retrieving_Single_Student {
	public static void main(String[] args) {
		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			session.beginTransaction();

			// now retrieve/read from database using the primary key
			A_Student myStudent = session.get(A_Student.class, Long.parseLong("1"));

			System.out.println("=====>" + myStudent);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
