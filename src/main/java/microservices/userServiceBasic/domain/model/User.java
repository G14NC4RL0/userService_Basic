package microservices.userServiceBasic.domain.model;

import java.util.UUID;

public class User {

	private UUID uuid;
	private String name;
	private String lastName;
	private String email;

	public User(UUID uuid, String name, String lastName, String email) {
		this.uuid = uuid;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) { this.uuid = uuid; }

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
}
