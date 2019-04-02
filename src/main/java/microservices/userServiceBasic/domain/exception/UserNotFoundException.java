package microservices.userServiceBasic.domain.exception;

import java.util.UUID;
import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException implements Supplier {

	public UserNotFoundException(UUID id) {
		super("User ID: " + id + " not found");
	}

	@Override
	public Object get() {
		return null;
	}
}
