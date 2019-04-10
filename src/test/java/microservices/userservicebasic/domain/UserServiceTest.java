package microservices.userservicebasic.domain;

import microservices.userservicebasic.domain.exception.UserNotFoundException;
import microservices.userservicebasic.domain.mapper.UserMapper;
import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.domain.model.UserDetails;
import microservices.userservicebasic.domain.validation.EmailValidation;
import microservices.userservicebasic.repository.UserRepository;
import microservices.userservicebasic.repository.model.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


	private static final UUID USER_UUID = UUID.randomUUID();
	private static final String FIRST_NAME = "Gian";
	private static final String LAST_NAME = "Tedesco";
	private static final String EMAIL = "giancarlo@gmail.com";

	@Mock
	private EmailValidation emailValidation;

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMapper userMapper;

	@InjectMocks
	private UserService userService;

	@Before
	public void setUp() {
	}

	@Test
	public void saveUserWithValidUserDetails() {
		// Given
		UserDetails userDetails = new UserDetails(FIRST_NAME, LAST_NAME, EMAIL);
		UserDto userDto = new UserDto(USER_UUID, FIRST_NAME, LAST_NAME, EMAIL);
		User expectedUser = new User(USER_UUID, FIRST_NAME, LAST_NAME, EMAIL);

		// When
		Mockito.when(userMapper.mapToUserDto(Mockito.any(User.class)))
				.thenReturn(userDto);
		Mockito.when(userRepository.save(userDto))
				.thenReturn(userDto);
		Mockito.when(userMapper.mapToUser(userDto))
				.thenReturn(expectedUser);

		User resultUser = userService.saveUser(userDetails);

		// Then
		assertEquals(expectedUser, resultUser);
		Mockito.verify(emailValidation, Mockito.times(1))
				.isValidEmailAddress(EMAIL);
	}

	@Test
	public void getUserWithValidUUID() {
		// Given
		UUID userUuid = UUID.randomUUID();
		UserDto userDto = new UserDto(userUuid, FIRST_NAME, LAST_NAME, EMAIL);
		User expectedUser = new User(userUuid, FIRST_NAME, LAST_NAME, EMAIL);

		// When
		Mockito.when(userRepository.findById(userUuid))
				.thenReturn(Optional.of(userDto));
		Mockito.when(userMapper.mapToUser(userDto))
				.thenReturn(expectedUser);

		User userResult = userService.getUser(userUuid);

		// Then
		assertEquals(expectedUser, userResult);
	}

	@Test
	public void getUserWithInvalidDataThrowsException() {
		// Given
		UUID userUuid = UUID.randomUUID();

		// When
		Mockito.when(userRepository.findById(userUuid))
				.thenReturn(Optional.empty());

		assertThatExceptionOfType(UserNotFoundException.class)
				.isThrownBy(() -> userService.getUser(userUuid))
				.withMessage("User ID: " + userUuid + " not found");
	}
}
