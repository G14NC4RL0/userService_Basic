package microservices.userservicebasic.domain.model;

import java.util.Objects;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!Objects.equals(uuid, user.uuid)) return false;
		if (!Objects.equals(name, user.name)) return false;
		if (!Objects.equals(lastName, user.lastName)) return false;
		return Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		int result = uuid != null ? uuid.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}
}
