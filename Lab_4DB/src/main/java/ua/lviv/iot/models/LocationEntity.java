package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "location")
public class LocationEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String  city;

    @Column(name = "Street")
    private String street;

    @Column(name = "Office Id")
    private Integer officeId;

    public LocationEntity(Integer id, String country, String city, String street, int officeId) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.officeId = officeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
}