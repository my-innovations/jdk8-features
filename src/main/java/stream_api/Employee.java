package stream_api;

import java.util.Date;
import java.util.List;

public class Employee {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private int age;
	private Date dob;
	private List<Long> mobileNos;
	private List<String> hubby;

	public Employee() {
	}

	public Employee(Long id, String firstname, String lastname, String email, int age, Date dob, List<Long> mobileNos,
			List<String> hubby) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.dob = dob;
		this.mobileNos = mobileNos;
		this.hubby = hubby;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Long> getMobileNos() {
		return mobileNos;
	}

	public void setMobileNos(List<Long> mobileNos) {
		this.mobileNos = mobileNos;
	}

	public List<String> getHubby() {
		return hubby;
	}

	public void setHubby(List<String> hubby) {
		this.hubby = hubby;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", age=" + age + ", dob=" + dob + ", mobileNos=" + mobileNos + ", hubby=" + hubby + "]";
	}

}
