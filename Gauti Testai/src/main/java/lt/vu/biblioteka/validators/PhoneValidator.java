package lt.vu.biblioteka.validators;


import lt.vu.biblioteka.model.PhoneRules;

import java.util.ArrayList;
import java.util.List;

public class PhoneValidator {


    public boolean validatePhone_Digits(String number) {
        if (number == null) {
            return false;
        }

        if (!number.startsWith("8") && !number.startsWith("+")) {
            return false;
        }

        if (number.startsWith("8")) {
            number = "+370" + number.substring(1);
        }

        List<Character> numbers = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (char c : number.substring(1).toCharArray()) {
            if (!numbers.contains(c)) {
                return false;
            }
        }


        List<PhoneRules> rulesList = new ArrayList<>();
        rulesList.add(new PhoneRules("Lithuania", 12, "+370"));
        rulesList.add(new PhoneRules("Lenkija", 12, "+39"));



        for (PhoneRules rules : rulesList) {
            if (number.startsWith(rules.getPrefix()) && number.length() == rules.getLengthOfPhoneNumber()) {
                return true;
            }
        }

        return false;
    }

    public String changePhoneNumber(String phoneNumber) {
        if (phoneNumber.startsWith("8")) {
            return "+370" + phoneNumber.substring(1);
        }
        return phoneNumber;
    }

    public PhoneRules addPhoneRules(String country, int lengthOfPhoneNumber, String prefix) {
        return new PhoneRules(country, lengthOfPhoneNumber, prefix);
    }
}
