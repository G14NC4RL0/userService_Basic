package microservices.userservicebasic.api.response;


import java.util.UUID;

public class UserResponse {

	private final UUID uuid;
	private final String firstName;
	private final String lastName;
	private final String email;

	public UserResponse(UUID uuid, String firstName, String lastName, String email) {
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
