package microservices.userservicebasic.domain.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(UUID id) {
		super("User ID: " + id + " not found");
	}
}
