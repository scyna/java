package io.scyna.ex.customer.model;

public class StreetAddress {
    private String street;
    private String district;
    private String province;
    private String country;

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder modify(StreetAddress address) {
        var ret = new Builder();
        ret.street = address.street;
        ret.district = address.district;
        ret.province = address.province;
        ret.country = address.country;
        return ret;
    }

    public static class Builder {
        private String street;
        private String district;
        private String province;
        private String country;

        public void withStreet(String street) {
            this.street = street;
        }

        public void withDistrict(String district) {
            this.district = district;
        }

        public void withProvince(String province) {
            this.province = province;
        }

        public void withCountry(String country) {
            this.country = country;
        }

        public StreetAddress build() throws io.scyna.Error {
            /* TODO: validate and throws Error here */
            var ret = new StreetAddress();
            ret.street = street;
            ret.district = district;
            ret.country = country;
            ret.province = province;
            return ret;
        }
    }
}
