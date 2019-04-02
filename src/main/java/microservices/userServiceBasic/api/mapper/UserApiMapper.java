package microservices.userServiceBasic.api.mapper;

import microservices.userServiceBasic.api.model.UserDetails;
import microservices.userServiceBasic.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

	public UserDetails mapToUserDetails(User user) {

		return new UserDetails(user.getName(), user.getLastName(), user.getEmail());
	}

	public User mapToUser(UserDetails userDetails) {

		return new User((userDetails.getId()), userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail());
	}
}
