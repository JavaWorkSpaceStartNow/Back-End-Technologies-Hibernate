package E_Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import D_Use_Of_Cascade_Type.A_Student;
import D_Use_Of_Cascade_Type.B_Profile;
import D_Use_Of_Cascade_Type.C_Address;
import D_Use_Of_Cascade_Type.D_Courses;

public class D_Use_Of_Cascade_Type_For_Save {
	public static void main(String[] args) {

		// 👉 Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(A_Student.class).addAnnotatedClass(B_Profile.class)
				.addAnnotatedClass(C_Address.class).addAnnotatedClass(D_Courses.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			// 👉 What Is Cascading?
			// Entity relationships often depend on the existence of another entity, for
			// example the Person–Address relationship. Without the Person, the Address
			// entity doesn’t have any meaning of its own. When we delete the Person entity,
			// our Address entity should also get deleted.

			// 👉 Cascading is the way to achieve this. When we perform some action on the
			// target entity, the same action will be applied to the associated entity.

			// 👉 JPA Cascade Type
			// All JPA-specific cascade operations are represented by the
			// javax.persistence.CascadeType enum containing entries:

			// 1.ALL => CascadeType.ALL propagates all operations — including
			// Hibernate-specific ones — from a parent to a child entity.

			// 2.PERSIST => The persist operation makes a transient instance persistent.
			// Cascade Type PERSIST propagates the persist operation from a parent to a
			// child entity. When we save the person entity, the address entity will also
			// get saved.

			// 3.MERGE => The merge operation copies the state of the given object onto the
			// persistent object with the same identifier. CascadeType.MERGE propagates the
			// merge operation from a parent to a child entity

			// 4.REMOVE => As the name suggests, the remove operation removes the row
			// corresponding to the entity from the database and also from the persistent
			// context.

			// CascadeType.REMOVE propagates the remove operation from parent to child
			// entity. Similar to JPA’s CascadeType.REMOVE, we have CascadeType.DELETE,
			// which is specific to Hibernate. There is no difference between the two.

			// 5.REFRESH => Refresh operations reread the value of a given instance from the
			// database. In some cases, we may change an instance after persisting in the
			// database, but later we need to undo those changes.

			// In that kind of scenario, this may be useful. When we use this operation with
			// Cascade Type REFRESH, the child entity also gets reloaded
			// from the database whenever the parent entity is refreshed.

			// 6.DETACH => The detach operation removes the entity from the persistent
			// context. When we use CascadeType.DETACH, the child entity will also get
			// removed from the persistent context.

			// start a transaction
			session.beginTransaction();

			// If We Need To A Way To Save The Profile Is Saved When We Saved A Student At
			// That Time The Profile Is Also Saved Than We Declare The (CascadeType.All)
			// Also This Works On All Time When We Need To Save Child Using Of It's Parent

			// But A Business Logic Is Say That When We Delete The Child Data Than There Are
			// Not Deleted It's Parent Data So We Can't Able To Give (CascadeType.All) At
			// Child Side.(We Learn This In Next E_Use_Of_Cascade_Type_For_Delete.java
			// Class)

			// And Also Some Time We Need That When We Try To Fetch The Any Result From
			// DataBase Than It's Mapped Entity Data Not To Be Fetched(We Learn This In Next
			// F_Use_Of_Fetch_Type.java Class)

			// Initialize An Array List Of The Address
			List<C_Address> addressList = new ArrayList<C_Address>();

			// Initialize An Array List Of The Course
			List<D_Courses> coursesList = new ArrayList<D_Courses>();

			// Initialize An Object Of The Student
			A_Student student = new A_Student();

			// Set Values In Profile Object
			B_Profile profile = new B_Profile();
			profile.setFirstName("Jay");
			profile.setMiddleName("PareshBhai");
			profile.setLastName("Pansuriya");
			profile.setEmail("jayp@exitosystems.com");
			profile.setStudent(student);

			// Set Values In Address Object
			C_Address address = new C_Address();
			address.setAddress1("B/38 Hansh Colony Opp 137 Last BusStop");
			address.setAddress2("Bapunager");
			address.setCity("AhemdaBad");
			address.setPostCode("380024");
			address.setRegion("Gujrat");
			address.setCountry("India");
			address.setContinent("Asia");
			address.setStudent(student);
			addressList.add(address);

			// Set Values In Address Object
			address = new C_Address();
			address.setAddress1("B/38 Hansh Colony Opp 137 Last BusStop");
			address.setAddress2("Bapunager");
			address.setCity("AhemdaBad");
			address.setPostCode("380024");
			address.setRegion("Gujrat");
			address.setCountry("India");
			address.setContinent("Asia");
			address.setStudent(student);
			addressList.add(address);

			// Set Values In Course Object
			D_Courses course = new D_Courses();
			course.setCourseName("Gujrati");
			course.setCourseCode("001");
			coursesList.add(course);

			// Set Values In Course Object
			course = new D_Courses();
			course.setCourseName("Hindi");
			course.setCourseCode("002");
			coursesList.add(course);

			// Set Values In Course Object
			course = new D_Courses();
			course.setCourseName("English");
			course.setCourseCode("003");
			coursesList.add(course);

			// Set Values In Student Object

			student.setProfile(profile);
			student.setAddresses(addressList);
			student.setCourses(coursesList);
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			sessionFactory.close();
		}
	}
}
