package lt.vu.laboratorinisdarbas3.service.impl;

import lt.vu.laboratorinisdarbas3.model.CountryRule;
import lt.vu.laboratorinisdarbas3.service.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneValidator implements Validator {

    private List<CountryRule> countryRuleList = new ArrayList<>();

    public PhoneValidator() {
    }

    @Override
    public boolean validate(String number) {
        return number != null && !number.isEmpty() && numberStartsWithPlusSign(number) && numberHasOnlyDigitsAndAPlusSign(number) && validByRule(number);
    }

    private boolean numberStartsWithPlusSign(String number) {
        return number.charAt(0) == '+';
    }

    private boolean numberHasOnlyDigitsAndAPlusSign(String number) {
        for (char symbol : number.toCharArray()) {
            if (!Character.isDigit(symbol) && symbol != '+') {
                return false;
            }
        }
        return true;
    }

    private boolean validByRule(String number) {
        boolean phoneValidRyRule = false;
        for (CountryRule rule :
                countryRuleList) {
            if (number.length() == rule.getNumberLength()) {
                int prefixLength = rule.getPrefix().length();
                String testNumber = number.substring(0, prefixLength);
                phoneValidRyRule = Objects.equals(testNumber, rule.getPrefix());
            }
        }
        return phoneValidRyRule;
    }

    public void addCountryRule(CountryRule countryRule) {
        countryRuleList.add(countryRule);
    }

    public String formatNumberToString(String countryCode, String number) {
        if (Objects.equals(countryCode, "LT") && number.charAt(0) == '8') {
            return "+370" + number.substring(1);
        }
        return number;
    }

    public void addNewCountryRule(CountryRule countryRule) {
        countryRuleList.add(countryRule);
    }
}
