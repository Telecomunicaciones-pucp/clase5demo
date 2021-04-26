package com.example.clase5demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierid")
    private int id;
    @Column(nullable = false)
    @NotBlank
    @Size(min=0,max=40,message = "El nombre de la compañia debe tener menos de 40 caracteres")
    private String companyname;
    @Size(min=0,max=30,message = "El nombre de contacto debe tener menos de 30 caracteres")
    private String contactname;
    @Size(min=0,max=30,message = "El título de contacto debe tener menos de 30 caracteres")
    private String contacttitle;
    @Size(min=0,max=60,message = "La dirección debe tener menos de 60 caracteres")
    private String address;
    @Size(min=0,max=15,message = "La ciudad debe tener menos de 15 caracteres")
    private String city;
    @Size(min=0,max=15,message = "La región debe tener menos de 15 caracteres")
    private String region;
    @Size(min=0,max=10,message = "El código postal debe tener menos de 10 caracteres")
    private String postalcode;
    @Size(min=0,max=15,message = "El país debe tener menos de 15 caracteres")
    private String country;
    @Size(min=0,max=24,message = "El numero de telefono debe tener menos de 24 caracteres")
    private String phone;
    @Size(min=0,max=24,message = "El fax debe tener menos de 24 caracteres")
    private String fax;
    private String homepage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContacttitle() {
        return contacttitle;
    }

    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
    }

}

