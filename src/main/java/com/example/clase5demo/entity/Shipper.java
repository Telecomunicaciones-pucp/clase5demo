package com.example.clase5demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipperid")
    private int shipperId;
    @Column(name = "companyname", nullable = false)
    @Size(min=0,max=40,message = "El nombre de la compañia debe tener menos de 40 caracteres")
    private String companyName;

    @Size(min=0,max=24,message = "El numero de telefono debe tener menos de 24 caracteres")
    private String phone;

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyname() {
        return companyName;
    }

    public void setCompanyname(String companyname) {
        this.companyName = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
