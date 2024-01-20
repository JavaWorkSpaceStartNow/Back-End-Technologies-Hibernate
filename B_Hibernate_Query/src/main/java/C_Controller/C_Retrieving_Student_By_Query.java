package C_Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_Entity.A_Student;

public class C_Retrieving_Student_By_Query {
	public static void main(String[] args) {
		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			session.beginTransaction();

			// Retrieving Students: lastName = ‘Pansuriya’
			List<A_Student> studentsByLastName = session.createQuery("from A_Student s where s.lastName='Pansuriya'")
					.getResultList();

			System.out.println("studentsByLastName=====>" + studentsByLastName);

			// Retrieving Students using OR predicate
			List<A_Student> studentsByFirstNameOrLastName = session
					.createQuery("from A_Student s where s.lastName='Pansuriya' OR  s.firstName='Jay'").getResultList();
			System.out.println("studentsByFirstNameOrLastName=====>" + studentsByFirstNameOrLastName);

			// Retrieving Students using LIKE predicate:
			List<A_Student> studentsByLIKE = session.createQuery("from A_Student s where s.email LIKE '%luv2code.com'")
					.getResultList();
			System.out.println("studentsByLIKE=====>" + studentsByLIKE);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
