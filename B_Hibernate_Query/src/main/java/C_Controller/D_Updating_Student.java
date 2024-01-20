package C_Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_Entity.A_Student;

public class D_Updating_Student {
	public static void main(String[] args) {// 👉 Create Session Factory
		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.openSession();

		try {

			// start a transaction
			session.beginTransaction();

			A_Student myStudent = null;

			// now retrieve/read from database using the primary key
			myStudent = session.get(A_Student.class, Long.parseLong("2"));
			System.out.println("BeforeUpdate=====>" + myStudent);

			// update first name to "Mansi"
			myStudent.setFirstName("Mansi");
			// update middleName name to "Jay"
			myStudent.setMiddleName("JayKumar");
			session.save(myStudent);

			// now retrieve/read from database using the primary key
			myStudent = session.get(A_Student.class, Long.parseLong("2"));
			System.out.println("AfterUpdate=====>" + myStudent);

			// Update first and middleName for all students
			session.createQuery("update A_Student set firstName='Jay',middleName='PareshBhai'").executeUpdate();

			// Retrieving all Students
			List<A_Student> students = session.createQuery("from A_Student").getResultList();

			System.out.println("AfterUpdate=====>" + students);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}

}
