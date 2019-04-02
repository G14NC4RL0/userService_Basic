package microservices.userServiceBasic.api;

import microservices.userServiceBasic.api.mapper.UserApiMapper;
import microservices.userServiceBasic.api.model.UserDetails;
import microservices.userServiceBasic.api.response.UserResponse;
import microservices.userServiceBasic.domain.UserService;
import microservices.userServiceBasic.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiRest implements UserApi {

	private final UserService userService;
	private final UserApiMapper userApiMapper;

	@Autowired
	public UserApiRest(UserService userService, UserApiMapper userApiMapper) {

		this.userService = userService;
		this.userApiMapper = userApiMapper;
	}

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserDetails userDetails) {

		User user = userService.saveUser(userApiMapper.mapToUser(userDetails));
		return ResponseEntity.ok(new UserResponse(userApiMapper.mapToUserDetails(user)));
	}

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserResponse> getUser(@RequestBody UserDetails userDetails) {

		User user = userService.getUser(userApiMapper.mapToUser(userDetails));
		return ResponseEntity.ok(new UserResponse(userApiMapper.mapToUserDetails(user)));
	}
}

