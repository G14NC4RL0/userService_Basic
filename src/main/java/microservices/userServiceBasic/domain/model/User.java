package microservices.userServiceBasic.domain.model;

import java.util.UUID;

public class User {

	private UUID id;
	private String name;
	private String lastName;
	private String email;
	private String address;
	private String nationality;

	public User(String name, String lastName, String email) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
