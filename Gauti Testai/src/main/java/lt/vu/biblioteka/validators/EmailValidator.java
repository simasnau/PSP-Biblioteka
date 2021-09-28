package lt.vu.biblioteka.validators;

import java.util.Arrays;

public class EmailValidator {
    private final String[] disallowedSymbols = {"_", "$"};
    private final String[] correctDomains = {"gmail.com", "mif.stud.vu.lt", "vps.random.com", "email.eu", "mail.net"};

    public boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }

        if (!email.contains("@")) {
            return false;
        }

        if (Arrays.stream(disallowedSymbols).anyMatch(email::contains)) {
            return false;
        }

        for (String domain:correctDomains) {
            if (email.endsWith("@" + domain)) {
                return true;
            }
        }
        return false;
    }
}
