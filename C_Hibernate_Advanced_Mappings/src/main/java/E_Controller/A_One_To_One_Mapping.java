package E_Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import A_One_To_One_Mapping.A_Student;
import A_One_To_One_Mapping.B_Profile;

public class A_One_To_One_Mapping {
	public static void main(String[] args) {

		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).addAnnotatedClass(B_Profile.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// associate the objects
			A_Student student = new A_Student();
			session.save(student);

			// Set Values In Profile Object
			B_Profile profile = new B_Profile();
			profile.setFirstName("Jay");
			profile.setMiddleName("PareshBhai");
			profile.setLastName("Pansuriya");
			profile.setEmail("jayp@exitosystems.com");
			profile.setStudent(student);

			// save the profile object
			session.save(profile);

			// save the student object
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
