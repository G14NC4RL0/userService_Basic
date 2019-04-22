package microservices.userservicebasic.domain.validation;

import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component
public class EmailValidation {

	public void isValidEmailAddress(String email) throws AddressException {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
	}
}
