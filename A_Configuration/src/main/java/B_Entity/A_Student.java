package B_Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity annotation marks this class as an entity.
@Entity
//@Table annotation specifies the table name where data of this entity is to be persisted. If you don't use @Table annotation, 
//        hibernate will use the class name as the table name by default.
@Table(name = "student")
public class A_Student {

	// @Id annotation marks the identifier for this entity.
	@Id
	@Column(name = "id")
	// @GeneratedValue annotation is to configure the way of increment of the
	// specified column(field). For example, when using Mysql, you may specify
	// auto_increment in the definition of table to make it self-incremental, and
	// then use
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// @Column annotation specifies the details of the column for this property or
	// field. If @Column annotation is not specified, property name will be used as
	// the column name by default.

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	public A_Student() {
		super();
	}

	public A_Student(long id, String firstName, String middleName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
