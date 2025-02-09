package com.pujariz.RestUserProject.DTO;

import com.pujariz.RestUserProject.Entity.Address;

public class AddressDTO {

    private long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String country;

    private String geoLat;
    private String geoLng;

    public AddressDTO(Address address) {
        this.id = address.getId(); // Assuming Address has a getId() method
        this.street = address.getStreet();
        this.suite = address.getSuite();
        this.city = address.getCity();
        this.zipcode = address.getZipcode();
        this.country = address.getCountry();
        this.geoLat = address.getGeo().getLat();
        this.geoLng = address.getGeo().getLng();
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(String geoLat) {
        this.geoLat = geoLat;
    }

    public String getGeoLng() {
        return geoLng;
    }

    public void setGeoLng(String geoLng) {
        this.geoLng = geoLng;
    }
}
