package microservices.userServiceBasic.api.mapper;

import microservices.userServiceBasic.api.model.UserDetails;
import microservices.userServiceBasic.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

    public UserDetails mapFrom(User user) {

        return new UserDetails();
    }

    public User mapTo(UserDetails userDetails) {

        return new User();
    }
}
