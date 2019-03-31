package microservices.userServiceBasic.domain.mapper;

import microservices.userServiceBasic.domain.model.User;
import microservices.userServiceBasic.repository.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public User mapToUser(UserDto userDto) {
		User user = new User(userDto.getName(), userDto.getLastName(), userDto.getEmail());
		return user;
	}

	public UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getName(), user.getLastName());
		return userDto;
	}
}
