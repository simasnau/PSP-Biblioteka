package lt.vu.laboratorinisdarbas3.service.impl;

import lt.vu.laboratorinisdarbas3.service.Validator;

import java.util.List;

public class PasswordChecker implements Validator {

    private List<Character> specialCharacters;

    @Override
    public boolean validate(String password) {
        return password != null && !password.isEmpty() && lengthIsCorrect(password) && passwordHasAllSymbols(password)
                && passwordOnlyHasLowerLetters(password) && passwordOnlyHasUpperLetters(password);
    }

    private boolean lengthIsCorrect(String password) {
        return password.length() >= 8;
    }

    private boolean passwordOnlyHasLowerLetters(String password) {
        return !password.toLowerCase().equals(password);
    }

    private boolean passwordOnlyHasUpperLetters(String password) {
        return !password.toUpperCase().equals(password);
    }

    private boolean passwordHasAllSymbols(String password) {
        boolean hasDigit = false;
        boolean onlyLettersAndDigits = true;
        for (char symbol : password.toCharArray()) {
            if (specialCharacters.stream().noneMatch(specialCharacters -> specialCharacters == symbol) && !Character.isLetterOrDigit(symbol)) {
                return false;
            }

            if (!Character.isLetterOrDigit(symbol)) {
                onlyLettersAndDigits = false;
            }

            if (Character.isDigit(symbol)) {
                hasDigit = true;
            }
        }

        if (!hasDigit) {
            return false;
        }

        if (onlyLettersAndDigits) {
            return false;
        }

        return true;
    }


    public void setSpecialCharacters(List<Character> specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    public void addSpecialCharacter(char c) {
        specialCharacters.add(c);
    }

    public void remove(char c) {
        specialCharacters.removeIf(ch -> ch.equals(c));
    }
}
