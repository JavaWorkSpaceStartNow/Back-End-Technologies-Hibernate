package C_Many_To_Many_Mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class C_Address {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "postCode")
	private String postCode;

	@Column(name = "region")
	private String region;

	@Column(name = "country")
	private String country;

	@Column(name = "continent")
	private String continent;

	// • Many student can have one addresses
	// • Inverse / opposite of One-to-Many
	// 👉 Real-World Project Requirement
	// • If you delete an student, DO NOT delete the addresses
	// • If you delete a addresses, DO NOT delete the student

	// 👉 • mappedBy tells Hibernate
	// • Look at the student property in the Address class
	// • Use information from the Address class @JoinColumn
	// • To help find associated Address for Student
	@ManyToOne
	@JoinColumn(name = "student_id")
	private A_Student student;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public A_Student getStudent() {
		return student;
	}

	public void setStudent(A_Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "C_Address [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", postCode=" + postCode + ", region=" + region + ", country=" + country + ", continent=" + continent
				+ ", student=" + student + "]";
	}

}
