package microservices.userservicebasic.domain.validation;

import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component
public class EmailValidation {

	public static Throwable emailValidationException;

	public void isValidEmailAddress(String email) {
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			throw new RuntimeException("email invalid");
		}
	}
}
