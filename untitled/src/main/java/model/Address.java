package model;

public class Address {
    private String street;
    private String city;
    private String state;
    private Integer number;
    private String district;
    private String cep;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Address(String street, String city, String state, Integer number, String district, String cep) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.number = number;
        this.district = district;
        this.cep = cep;
    }

}
