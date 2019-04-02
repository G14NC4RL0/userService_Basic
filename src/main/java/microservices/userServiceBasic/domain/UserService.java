package microservices.userServiceBasic.domain;

import microservices.userServiceBasic.domain.exception.UserNotFoundException;
import microservices.userServiceBasic.domain.mapper.UserMapper;
import microservices.userServiceBasic.domain.model.User;
import microservices.userServiceBasic.domain.validation.EmailValidation;
import microservices.userServiceBasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

	private final EmailValidation emailValidation;
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Autowired
	public UserService(EmailValidation emailValidation, UserRepository userRepository, UserMapper userMapper) {

		this.emailValidation = emailValidation;
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}


	public User saveUser(User user) {

		if ( !emailValidation.isValidEmailAddress(user.getEmail()) ) {
			throw emailValidation.emailValidationException;
		}
		user.setUuid(UUID.randomUUID());
		userRepository.save(userMapper.mapToUserDto(user));
	}

	public User getUser(User user) {

		return userRepository.findById(user.getUuid())
				.orElseThrow(new UserNotFoundException(user.getUuid()));
	}
}

