package microservices.userservicebasic.domain.model;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class UserTest {

	private static final UUID USER_UUID = UUID.randomUUID();
	private static final String FIRST_NAME = "Gian";
	private static final String LAST_NAME = "Tedesco";
	private static final String EMAIL = "giancarlo@gmail.com";

	private User user;

	@Before
	public void setUp() throws Exception {
		user = new User(USER_UUID, FIRST_NAME, LAST_NAME, EMAIL);
	}

	@Test
	public void getUuid() {
		// When
		UUID uuidResult = user.getUuid();

		// Then
		assertEquals(USER_UUID, uuidResult);
	}

	// Leaving this code to discuss later in person about testing setters and getters

	@Test
	public void setUuid() {

	}

	@Test
	public void getName() {
	}

	@Test
	public void setName() {
	}

	@Test
	public void getLastName() {
	}

	@Test
	public void setLastName() {
	}

	@Test
	public void getEmail() {
	}

	@Test
	public void setEmail() {
	}
}
