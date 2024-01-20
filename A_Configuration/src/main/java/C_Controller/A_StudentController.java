package C_Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_Entity.A_Student;

public class A_StudentController {
	public static void main(String[] args) {
		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.openSession();

		try {
			// Set Values In Student Object
			A_Student student = new A_Student();
			student.setFirstName("Jay");
			student.setMiddleName("PareshBhai");
			student.setLastName("Pansuriya");
			student.setEmail("jayp@exitosystems.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
