package lt.vu.laboratorinisdarbas3.model;

public class CountryRule {
    private String countryCode;
    private Long numberLength;
    private String prefix;

    public CountryRule(String countryCode, Long numberLength, String prefix) {
        this.countryCode = countryCode;
        this.numberLength = numberLength;
        this.prefix = prefix;
    }

    public Long getNumberLength() {
        return numberLength;
    }

    public String getPrefix() {
        return prefix;
    }
}
