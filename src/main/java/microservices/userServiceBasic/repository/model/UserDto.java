package microservices.userServiceBasic.repository.model;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class UserDto {

	private UUID id;
	private String name;
	private String lastName;
	private String email;

	public UserDto(UUID id, String name, String lastName, String email) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	public UUID getId() {
		return id;
	}

	public String getFirstName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) { this.email = email; }

}
