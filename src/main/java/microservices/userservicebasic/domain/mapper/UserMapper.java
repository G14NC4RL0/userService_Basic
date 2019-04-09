package microservices.userservicebasic.domain.mapper;

import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.repository.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public User mapToUser(UserDto userDto) {
		User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
		return user;
	}

	public UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getUuid(), user.getName(), user.getLastName(), user.getEmail());
		return userDto;
	}
}

