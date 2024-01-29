package D_Use_Of_Cascade_Type;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class A_Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Bi-Directional
	// => mappedBy tells Hibernate
	// • Look at the profile property in the B_Profile class
	// • Use information from the B_Profile class @JoinColumn
	// • To help find associated student
	// All cascade types
	@OneToOne(mappedBy = "student", cascade = { CascadeType.ALL })
	private B_Profile profile;

	// • An student can have many addresses
	// • Bi-directional
	@OneToMany(mappedBy = "student", cascade = { CascadeType.ALL })
	private List<C_Address> addresses;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<D_Courses> courses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public B_Profile getProfile() {
		return profile;
	}

	public void setProfile(B_Profile profile) {
		this.profile = profile;
	}

	public List<C_Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<C_Address> addresses) {
		this.addresses = addresses;
	}

	public List<D_Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<D_Courses> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "A_Student [id=" + id + ", profile=" + profile + "]";
	}

}
