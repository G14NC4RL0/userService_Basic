package microservices.userservicebasic.domain;

import microservices.userservicebasic.domain.mapper.UserMapper;
import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.domain.model.UserDetails;
import microservices.userservicebasic.domain.validation.EmailValidation;
import microservices.userservicebasic.repository.UserRepository;
import microservices.userservicebasic.repository.model.UserDto;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserServiceTest {


	private static final String FIRST_NAME = "Gian";
	private static final String LAST_NAME = "Tedesco";
	private static final String EMAIL = "giancarlo@gmail.com";

	private EmailValidation emailValidation;
	private UserRepository userRepository;
	// What to do in this case?
	private UserMapper userMapper;
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		emailValidation = new EmailValidation();
		userMapper = new UserMapper();
		userService = new UserService(emailValidation, userRepository, userMapper);
	}

	@Test
	public void saveUserWithValidUserDetails() {
		// Given
		UserDetails userDetails = new UserDetails(FIRST_NAME, LAST_NAME, EMAIL);

		// When
		User expectedUser = userService.saveUser(userDetails);

		// Then
		assertEquals(expectedUser.getName(), userDetails.getFirstName());
		assertEquals(expectedUser.getLastName(), userDetails.getLastName());
		assertEquals(expectedUser.getEmail(), userDetails.getEmail());
	}

	@Test
	public void getUserWithValidUUID() {
		// Given
		UUID userUuid = UUID.randomUUID();
		UserDto userDto = new UserDto(userUuid, FIRST_NAME, LAST_NAME, EMAIL);
		userRepository.save(userDto);
		User expectedUser = new User(userUuid, FIRST_NAME, LAST_NAME, EMAIL);

		// When
		User userResult = userService.getUser(userUuid);

		// Then
		assertEquals(expectedUser, userResult);
	}
}
