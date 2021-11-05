package lt.vu.laboratorinisdarbas3;

import lt.vu.laboratorinisdarbas3.model.CountryRule;
import lt.vu.laboratorinisdarbas3.service.impl.PhoneValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PhoneValidatorTest {
    PhoneValidator phoneValidator;

    @BeforeEach
    void setUp() {
        phoneValidator = new PhoneValidator();
        CountryRule lithuania = new CountryRule("LT", 12L, "+370");
        phoneValidator.addCountryRule(lithuania);
    }

    @Test
    public void numberContainsNonDigits() {
        assertFalse(phoneValidator.validate("(+370)6 455 555 9"));
    }

    @Test
    public void changeToCountryCode() {
        assertEquals("+37061234567", phoneValidator.formatNumberToString("LT", "861234567"));
    }

    @Test
    public void NumberOk() {
        assertTrue(phoneValidator.validate("+37054444444"));
        assertEquals("+37054444444", phoneValidator.formatNumberToString("LT", "+37054444444"));
    }

    @Test
    public void unknownRuleOrIncorrectNumber() {
        assertFalse(phoneValidator.validate("+12399999999"));
    }

    @Test
    public void newRule() {
        CountryRule exoticIsland = new CountryRule("exotic_island", 10L, "+25");
        phoneValidator.addNewCountryRule(exoticIsland);

        assertEquals("+254455666", phoneValidator.formatNumberToString("egzotine_sala", "+254455666"));
    }


}
