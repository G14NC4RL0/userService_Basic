package microservices.userServiceBasic.api.model;

public class UserDetails {

	private String name;
	private String lastName;
	private String email;

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDetails(String name) {
		this.name = name;
	}

	public UserDetails(String name, String lastName, String email) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
}
