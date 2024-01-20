package C_Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_Entity.A_Student;

public class B_Retrieving_All_Student {
	public static void main(String[] args) {
		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			session.beginTransaction();

			// Retrieving all Students
			List<A_Student> students = session.createQuery("from A_Student").getResultList();

			System.out.println("=====>" + students);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
