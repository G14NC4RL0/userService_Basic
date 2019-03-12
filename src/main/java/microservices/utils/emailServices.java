package microservices.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class emailServices {

    public static boolean isValidEmailAddress(String email) {
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
