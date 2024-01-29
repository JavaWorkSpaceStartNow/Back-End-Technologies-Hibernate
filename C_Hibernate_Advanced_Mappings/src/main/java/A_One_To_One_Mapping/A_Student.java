package A_One_To_One_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
