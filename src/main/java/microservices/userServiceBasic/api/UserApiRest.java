package microservices.userServiceBasic.api;

import microservices.userServiceBasic.api.mapper.UserApiMapper;
import microservices.userServiceBasic.api.model.UserDetails;
import microservices.userServiceBasic.api.response.UserResponse;
import microservices.userServiceBasic.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiRest implements UserApi {

	private UserService userService;

	@Autowired
	public UserApiRest(UserService userService) {
		this.userService = userService;
	}

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserDetails user) {

		userService.saveUser(UserApiMapper.mapToUser(user));
		return ResponseEntity.ok(new UserResponse());
	}
}
