package E_Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import D_Use_Of_Cascade_Type.A_Student;
import D_Use_Of_Cascade_Type.B_Profile;
import D_Use_Of_Cascade_Type.C_Address;
import D_Use_Of_Cascade_Type.D_Courses;

public class E_Use_Of_Cascade_Type_For_Delete {
	public static void main(String[] args) {

		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).addAnnotatedClass(B_Profile.class)
				.addAnnotatedClass(C_Address.class).addAnnotatedClass(D_Courses.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// If We Need To A Way To Save The Profile Is Saved When We Saved A Student At
			// That Time The Profile Is Also Saved Than We Declare The (CascadeType.All)
			// Also This Works On All Time When We Need To Save Child Using Of It's Parent

			// But A Business Logic Is Say That When We Delete The Child Data Than There Are
			// Not Deleted It's Parent Data So We Can't Able To Give (CascadeType.All) At
			// Child Side.

			// And Also Some Time We Need That When We Try To Fetch The Any Result From
			// DataBase Than It's Mapped Entity Data Not To Be Fetched(We Learn This In Next
			// F_Use_Of_Fetch_Type.java Class)

			// 1.If We Delete Student Profile Than It's Parent Object Is Not Deleted
			List<B_Profile> profiles = session.createQuery("from B_Profile").getResultList();

			if (!profiles.isEmpty()) {
				B_Profile profile = session.get(B_Profile.class, profiles.get(0).getId());
				System.out.println("===>" + profile);
				// Here If We Try To Delete Profile Than Student Not Deleted(For Delete This We
				// Need To Make FetchType.Lazy On It's Student Object(See Profile Class For More
				// Information))
				// session.delete(profile);
			}

			// 2.If We Delete Student Address Than It's Parent Object Is Not Deleted
			List<C_Address> addressses = session.createQuery("from C_Address").getResultList();
			if (!addressses.isEmpty()) {
				C_Address address = session.get(C_Address.class, addressses.get(0).getId());
				System.out.println("===>" + address);
				// Here If We Try To Delete Address Than Student Not Deleted
				// session.delete(address);
			}

			// 3.If We Delete Student Courses Than It's Parent Object Is Not Deleted
			List<D_Courses> courses = session.createQuery("from D_Courses").getResultList();
			if (!courses.isEmpty()) {
				D_Courses course = session.get(D_Courses.class, courses.get(0).getId());
				System.out.println("===>" + course);
				// Here If We Try To Delete Courses Than Student Not Deleted
				// session.delete(course);
			}

			// 4.If We Delete Student Than It's Child Object Is Also Deleted
			List<A_Student> students = session.createQuery("from A_Student").getResultList();
			if (!students.isEmpty()) {
				A_Student student = session.get(A_Student.class, students.get(0).getId());
				System.out.println("===>" + student);
				// Here If We Try To Delete Courses Than Student Not Deleted
				// session.delete(student);
			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
