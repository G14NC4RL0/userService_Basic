package microservices.userservicebasic.domain.mapper;

import microservices.userservicebasic.domain.model.User;
import microservices.userservicebasic.repository.model.UserDto;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserMapperTest {

	private static final String FIRST_NAME = "Gian";
	private static final String LAST_NAME = "Tedesco";
	private static final String EMAIL = "giancarlo@gmail.com";

	private UserMapper userMapper;

	@Before
	public void setUp() {
		userMapper = new UserMapper();
	}

	@Test
	public void mapToUserWithValidUserDto() {
		// Given
		UserDto userDto = new UserDto(UUID.randomUUID(), FIRST_NAME, LAST_NAME, EMAIL);
		User expectedUser = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());

		// When
		User userResult = userMapper.mapToUser(userDto);

		// Then
		assertEquals(expectedUser, userResult);
	}

	@Test
	public void mapToUserDtoWithValidUser() {
		// Given
		User user = new User(UUID.randomUUID(),FIRST_NAME, LAST_NAME, EMAIL);
		UserDto expectedUserDto = new UserDto(user.getUuid(), user.getName(), user.getLastName(), user.getEmail());

		// When
		UserDto userResult = userMapper.mapToUserDto(user);

		// Then
		assertEquals(expectedUserDto, userResult);
	}
}
