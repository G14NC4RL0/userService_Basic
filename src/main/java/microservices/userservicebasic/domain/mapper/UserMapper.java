package microservices.userservicebasic.domain.mapper;

import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.repository.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public User mapToUser(UserDto userDto) {
		return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
	}

	public UserDto mapToUserDto(User user) {
		return new UserDto(user.getUuid(), user.getName(), user.getLastName(), user.getEmail());
	}
}

