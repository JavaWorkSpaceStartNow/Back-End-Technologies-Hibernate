package E_Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import B_One_To_Many_And_Many_To_One_Mapping.A_Student;
import B_One_To_Many_And_Many_To_One_Mapping.B_Profile;
import B_One_To_Many_And_Many_To_One_Mapping.C_Address;

public class B_One_To_Many_And_Many_To_One_Mapping {
	public static void main(String[] args) {
		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).addAnnotatedClass(B_Profile.class)
				.addAnnotatedClass(C_Address.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// associate the objects
			A_Student student = new A_Student();

			// save the student object
			session.save(student);

			// Set Values In Student Object
			B_Profile profile = new B_Profile();
			profile.setFirstName("Jay");
			profile.setMiddleName("PareshBhai");
			profile.setLastName("Pansuriya");
			profile.setEmail("jayp@exitosystems.com");
			profile.setStudent(student);

			// save the profile object
			session.save(profile);

			C_Address address1 = new C_Address();
			address1.setAddress1("B/38 Hansh Colony Opp 137 Last BusStop");
			address1.setAddress2("Bapunager");
			address1.setCity("AhemdaBad");
			address1.setPostCode("380024");
			address1.setRegion("Gujrat");
			address1.setCountry("India");
			address1.setContinent("Asia");
			address1.setStudent(student);
			// save the address1 object
			session.save(address1);

			C_Address address2 = new C_Address();
			address2.setAddress1("B/38 Hansh Colony Opp 137 Last BusStop");
			address2.setAddress2("Bapunager");
			address2.setCity("AhemdaBad");
			address2.setPostCode("380024");
			address2.setRegion("Gujrat");
			address2.setCountry("India");
			address2.setContinent("Asia");
			address2.setStudent(student);
			// save the address2 object
			session.save(address2);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
