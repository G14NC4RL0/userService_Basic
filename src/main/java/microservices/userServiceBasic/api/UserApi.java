package microservices.userServiceBasic.api;

import microservices.userServiceBasic.api.model.UserDetails;
import microservices.userServiceBasic.api.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserApi {

    ResponseEntity<UserResponse> createUser(UserDetails user);
}
