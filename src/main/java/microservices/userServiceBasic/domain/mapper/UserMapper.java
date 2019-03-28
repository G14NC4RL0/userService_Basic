package microservices.userServiceBasic.domain.mapper;

import microservices.userServiceBasic.domain.model.User;
import microservices.userServiceBasic.repository.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapFrom(UserDto userDto) {
        return new User();
    }

    public UserDto mapTo(User user) {
        return new UserDto();
    }
}
