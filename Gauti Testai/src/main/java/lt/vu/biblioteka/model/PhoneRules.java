package lt.vu.biblioteka.model;

public class PhoneRules {

    public PhoneRules() {}
    public PhoneRules(String country, int lengthOfPhoneNumber, String prefix) {
        this.country = country;
        this.lengthOfPhoneNumber = lengthOfPhoneNumber;
        this.prefix = prefix;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLengthOfPhoneNumber(int lengthOfPhoneNumber) {
        this.lengthOfPhoneNumber = lengthOfPhoneNumber;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCountry() {
        return this.country;
    }

    public int getLengthOfPhoneNumber() {
        return this.lengthOfPhoneNumber;
    }

    public String getPrefix() {
        return this.prefix;
    }

    private String country;
    private int lengthOfPhoneNumber;
    private String prefix;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PhoneRules) {
            return country.equals(((PhoneRules) obj).getCountry()) && lengthOfPhoneNumber == ((PhoneRules) obj).getLengthOfPhoneNumber() && prefix.equals(((PhoneRules) obj).getPrefix());
        }
        return super.equals(obj);
    }
}
