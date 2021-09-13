import lt.vu.biblioteka.validator.EmailValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailTests {

    EmailValidator emailValidator;
    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"labas@gmail.com", "labas@mif.stud.vu.lt"})
    void TestCorrectEmail(String email) {
        assertTrue(emailValidator.isEmailValid(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"labaspasauli#", "labasgmail.com", "1234", ""})
    void testIncorrectEmail(String email) {
        assertFalse(emailValidator.isEmailValid(email));
    }

    @Test
    void TestNullEmail() {
        assertFalse(emailValidator.isEmailValid(null));
    }

    @AfterEach
    void tearDown() {
    }
}
