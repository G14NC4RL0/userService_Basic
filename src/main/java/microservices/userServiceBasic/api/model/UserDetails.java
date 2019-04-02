package microservices.userServiceBasic.api.model;

import java.util.UUID;

public class UserDetails {

	private final UUID id;
	private final String firstName;
	private final String lastName;
	private final String email;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public UserDetails(UUID id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDetails(String firstName, String lastName, String email) {
		this.id = new UUID(0L, 0L);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}
}
