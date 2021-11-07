package lt.vu.biblioteka.validators;

import java.util.stream.Stream;

public class PasswordChecker {
    public boolean validatePassword(String password, int passwordLength, char[] specialSymbols) {
        Stream<CharSequence> charStream = new String(specialSymbols).chars().mapToObj(i->String.valueOf((char)i));

        return password != null && password.length() >= passwordLength && charStream.anyMatch(password::contains) && !password.equals(password.toLowerCase());
    }
}
