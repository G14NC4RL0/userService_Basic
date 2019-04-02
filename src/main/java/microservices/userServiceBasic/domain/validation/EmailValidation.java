package microservices.userServiceBasic.domain.validation;

import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component
public class EmailValidation {

	public static Throwable emailValidationException;

	public boolean isValidEmailAddress(String email) {
		boolean valid = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			valid = false;
		}
		return valid;
	}
}
