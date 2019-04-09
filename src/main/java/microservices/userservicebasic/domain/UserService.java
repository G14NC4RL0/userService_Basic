package microservices.userservicebasic.domain;

import microservices.userservicebasic.domain.exception.UserNotFoundException;
import microservices.userservicebasic.domain.mapper.UserMapper;
import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.domain.model.UserDetails;
import microservices.userservicebasic.domain.validation.EmailValidation;
import microservices.userservicebasic.repository.UserRepository;
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


	public User saveUser(UserDetails userDetails) {

		emailValidation.isValidEmailAddress(userDetails.getEmail());
		final User user = new User(UUID.randomUUID(), userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail());
		return userMapper.mapToUser(userRepository.save(userMapper.mapToUserDto(user)));
	}

	public User getUser(UUID userUuid) {
		return userMapper.mapToUser(userRepository.findById(userUuid)
				.orElseThrow(() -> new UserNotFoundException(userUuid)));
	}

}

