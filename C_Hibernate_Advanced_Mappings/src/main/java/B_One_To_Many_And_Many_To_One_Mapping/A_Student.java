package B_One_To_Many_And_Many_To_One_Mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@OneToOne(mappedBy = "student")
	private B_Profile profile;

	// • An student can have many addresses
	// • Bi-directional
	@OneToMany(mappedBy = "student")
	private List<C_Address> addresses;

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

}