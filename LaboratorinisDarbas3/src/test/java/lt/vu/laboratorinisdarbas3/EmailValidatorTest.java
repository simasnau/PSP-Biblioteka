package lt.vu.laboratorinisdarbas3;

import lt.vu.laboratorinisdarbas3.service.impl.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmailValidatorTest {
    EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
       emailValidator = new EmailValidator();
    }

    @Test
    public void missingAtSymbol() {
        assertFalse(emailValidator.validate("petras.petraitismif.stud.vu.lt"));
    }

    @Test
    public void invalidCharacter() {
        assertFalse(emailValidator.validate("jonas jon'<?php/>@gmail.com"));
    }

    @Test
    public void dotFirst() {
        assertFalse(emailValidator.validate(".klausk@lrt.lt"));
    }

    @Test
    public void dotLast() {
        assertFalse(emailValidator.validate("klausk@lrt.lt."));
    }

    @Test
    public void dotsConsecutive() {
        assertFalse(emailValidator.validate("klau..sk@lr%*t.lt"));
    }

    @Test
    public void mixedCaseInRecipiantName() {
        assertTrue(emailValidator.validate("PAgaLbA@topocentras.org"));
    }

    @Test
    public void hyphenInDomainName() {
        assertTrue(emailValidator.validate("keturi@penki-skaicius.lt"));
    }

    @Test
    public void unicodeCharactersInRecipientName() {
        assertFalse(emailValidator.validate("ramūnas.bėgikas@sportas.eu"));
    }

}
