package microservices.userServiceBasic.domain;

import microservices.userServiceBasic.domain.mapper.UserMapper;
import microservices.userServiceBasic.domain.model.User;
import microservices.userServiceBasic.domain.validation.EmailValidation;
import microservices.userServiceBasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // All the logic

    private final EmailValidation emailValidation;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(EmailValidation emailValidation, UserRepository userRepository, UserMapper userMapper) {
        this.emailValidation = emailValidation;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public void saveUser(User user) {
//        if (emailValidation.isValidEmailAddress(user.getEmail())) {
//            throw new IllegalArgumentException("Email is invalid");
//        }
//        userRepository.save(userMapper.mapTo(user));
    }
}
