package lt.vu.laboratorinisdarbas3.service.impl;

import lt.vu.laboratorinisdarbas3.service.Validator;

public class EmailValidator implements Validator {
    public EmailValidator() {
    }

    private int etaSymbolPlace;

    public static String ALLOWED_CHARACTERS = " !#$%&'*+-/=?^_`{|}~";
    public static String LITHUANIAN_LETTERS = "ąčęėįšųūĄČĘĖĮŠŲŪ";

    @Override
    public boolean validate(String email) {
        return email != null && !email.isEmpty() && hasEtaSymbol(email) && localPartValid(email) && domainPartValid(email);
    }

    private boolean hasEtaSymbol(String email) {
        long etaOccurrences = email.chars().filter(ch -> ch == '@').count();
        etaSymbolPlace = email.indexOf("@");

        return etaSymbolPlace != -1 && etaOccurrences <= 1;
    }

    private boolean localPartValid(String email) {
        String localPart = email.substring(0, etaSymbolPlace);
        if (localPart.length() > 64) {
            return false;
        }

        if (!Character.isLetterOrDigit(localPart.charAt(0))) {
            return false;
        }

        boolean onlyAllowedSymbols;
        boolean usingLithualianLetters;
        for (char symbol : localPart.toCharArray()) {
            onlyAllowedSymbols = Character.isLetterOrDigit(symbol) || ALLOWED_CHARACTERS.contains("" + symbol);
            usingLithualianLetters = LITHUANIAN_LETTERS.contains("" + symbol);
            if (!onlyAllowedSymbols || usingLithualianLetters) {
                return false;
            }
        }
        return true;
    }

    private boolean domainPartValid(String email) {
        String domainName = email.substring(etaSymbolPlace + 1);

        if (domainName.endsWith(".")) {
            return false;
        }

        String[] domainNameSplits = domainName.split("\\.");

        if (domainNameSplits.length == 0) {
            return false;
        }

        for (String splitDomain : domainNameSplits) {
            if (splitDomain.isEmpty()) {
                return false;
            }
            if (splitDomain.length() < 2 || splitDomain.length() > 63) {
                return false;
            }
            for (char symbol : splitDomain.toCharArray()) {
                if (!Character.isLetterOrDigit(symbol)) {
                    if (!(symbol == '-')) {
                        return false;
                    }
                }
            }

        }
        return true;
    }


}
