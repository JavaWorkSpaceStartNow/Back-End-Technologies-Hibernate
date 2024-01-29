package C_CMS_Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class A_User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "first name is required")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "middle name is required")
	@Column(name = "middle_name")
	private String middleName;

	@NotEmpty(message = "last name is required")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "gender is required")
	@Column(name = "gender")
	private String gender;

	@NotEmpty(message = "email address is required")
	@Column(name = "email_address")
	private String emailAddress;

	@NotEmpty(message = "phone number is required")
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotEmpty(message = "technologies is required")
	@Column(name = "technologies")
	private String[] technologies;

	@NotEmpty(message = "country is required")
	@Column(name = "country")
	private String country;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String[] getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String[] technologies) {
		this.technologies = technologies;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
