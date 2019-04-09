package microservices.userservicebasic.api;

import microservices.userservicebasic.domain.model.UserDetails;
import microservices.userservicebasic.api.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserApi {

	ResponseEntity<UserResponse> createUser(UserDetails user);
	ResponseEntity<UserResponse> getUser(UUID uuid);
}
