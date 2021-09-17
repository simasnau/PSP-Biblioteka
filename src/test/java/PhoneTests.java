import lt.vu.biblioteka.model.Country;
import lt.vu.biblioteka.validator.PhoneValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneTests {
    PhoneValidator phoneValidator;
    List<Country> countryList;

    @BeforeEach
    void setUp() {
        phoneValidator = new PhoneValidator();
        countryList = List.of(
                new Country("Lietuva", "+370", 12),
                new Country("Lenkija", "+48", 12),
                new Country("Latvija", "+371", 12));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+37011111111", "+37111111111", "+48111111111", "800000000"})
    void TestCorrectPhone(String phone) {
        assertTrue(phoneValidator.isPhoneValid(phone, countryList));
    }

    @ParameterizedTest
    @ValueSource(strings = {"37011111111", "aaaaaaaaaaa", "+37011111", "+37011+11111"})
    void TestIncorrectPhone(String phone) {
        assertFalse(phoneValidator.isPhoneValid(phone, countryList));
    }

    @Test
    void TestNullPhone() {
        assertFalse(phoneValidator.isPhoneValid(null, countryList));
    }

    @AfterEach
    void tearDown() {

    }
}
