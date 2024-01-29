package E_Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import D_Use_Of_Cascade_Type.A_Student;
import D_Use_Of_Cascade_Type.B_Profile;
import D_Use_Of_Cascade_Type.C_Address;
import D_Use_Of_Cascade_Type.D_Courses;

public class F_Use_Of_Fetch_Type {
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
			// DataBase Than It's Mapped Entity Data Not To Be Fetched

			// 👉 Eager and Lazy Loading
			// The first thing that we should discuss here is what lazy loading and eager
			// loading are:

			// 1.Eager Loading is a design pattern in which data initialization occurs on
			// the
			// spot.

			// 2.Lazy Loading is a design pattern that we use to defer initialization of an
			// object as long as it’s possible.

			// 👉 Hibernate Default FetchType
			// 1.OneToMany: LAZY
			// 2.ManyToOne: EAGER
			// 3.ManyToMany: LAZY
			// 4.OneToOne: EAGER

			// 1.If We Fetch Student Than There Are Already Fetched Data Of It's @OneToOne
			// And @ManyToOne Mapping

			List<A_Student> students = session.createQuery("from A_Student").getResultList();
			if (!students.isEmpty()) {
				A_Student student = session.get(A_Student.class, students.get(0).getId());
				System.out.println("===>" + student);
			}

			// 2.If We Fetch Student Than There Are Already Fetched Data Of It's @OneToOne
			// And @ManyToOne Mapping But We Also Need To Fetch Data Of That @OneToMany And
			// @ManyToMany.So For That We Need To Override The Default FetchType.(See For
			// More Information On A_Student @ManyToMany And @OneToMany And Uncomment The
			// Commented Part)

			if (!students.isEmpty()) {
				A_Student student = session.get(A_Student.class, students.get(0).getId());
				System.out.println("===>" + student);
			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
