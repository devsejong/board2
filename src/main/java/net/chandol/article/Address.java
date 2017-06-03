package net.chandol.article;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String country;
    private String street;

    protected Address() {
    }

    public Address(String country, String street) {
        this.country = country;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        return street != null ? street.equals(address.street) : address.street == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }
}
