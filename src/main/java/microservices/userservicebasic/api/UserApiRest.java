package microservices.userservicebasic.api;

import microservices.userservicebasic.api.response.UserResponse;
import microservices.userservicebasic.domain.UserService;
import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.domain.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserApiRest implements UserApi {

	private final UserService userService;

	@Autowired
	public UserApiRest(UserService userService) {

		this.userService = userService;
	}

	@Override
	@PostMapping(value = "/user", produces = "application/json")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserDetails userDetails) {

		User user = userService.saveUser(userDetails);
		return ResponseEntity.ok(new UserResponse(user.getUuid(), user.getName(), user.getLastName(), user.getEmail()));
	}

	@Override
	@GetMapping(value = "/user/{userUuid}", produces = "application/json")
	public ResponseEntity<UserResponse> getUser(@PathVariable UUID userUuid) {

		User user = userService.getUser(userUuid);
		return ResponseEntity.ok(new UserResponse(user.getUuid(), user.getName(), user.getLastName(), user.getEmail()));
	}
}

