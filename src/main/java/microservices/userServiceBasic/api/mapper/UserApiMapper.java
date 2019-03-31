package microservices.userServiceBasic.api.mapper;

import microservices.userServiceBasic.api.model.UserDetails;
import microservices.userServiceBasic.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

	public static UserDetails mapToUserDetails(User user) {

		return new UserDetails(user.getName(), user.getLastName(), user.getEmail());
	}

	public static User mapToUser(UserDetails userDetails) {

		return new User(userDetails.getName(), userDetails.getLastName(), userDetails.getEmail());
	}
}
