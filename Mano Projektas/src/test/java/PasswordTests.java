import lt.vu.biblioteka.validator.PasswordChecker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordTests {

    PasswordChecker passwordChecker;
    @BeforeEach
    void setUp() {
        passwordChecker = new PasswordChecker();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Labaspasauli#", "13246545LLLL$"})
    void TestCorrectPassword(String password) {
        assertTrue(passwordChecker.isPasswordValid(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"labaspasauli#", "Labaspasauli", "1234", ""})
    void TestIncorrectPassword(String password) {
        assertFalse(passwordChecker.isPasswordValid(password));
    }

    @Test
    void TestNullPassword() {
        assertFalse(passwordChecker.isPasswordValid(null));
    }

    @AfterEach
    void tearDown() {

    }
}
