package C_Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_Entity.A_Student;

public class E_Deleting_Student {
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
			List<A_Student> studentsBeforeDelete = session.createQuery("from A_Student").getResultList();

			System.out.println("studentsBeforeDelete=====>" + studentsBeforeDelete);

			// now retrieve/read from database using the primary key
			A_Student myStudent = session.get(A_Student.class, Long.parseLong("4"));

			// delete the student
			session.delete(myStudent);

			// Another way of deleting

			session.createQuery("delete from A_Student where id=3").executeUpdate();

			// Retrieving all Students
			List<A_Student> studentsAfterDelete = session.createQuery("from A_Student").getResultList();

			System.out.println("studentsAfterDelete=====>" + studentsAfterDelete);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
