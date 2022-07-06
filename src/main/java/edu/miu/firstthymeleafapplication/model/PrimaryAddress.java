package edu.miu.firstthymeleafapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="primary_addresses")
public class PrimaryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "primaryAddress")
    private Publisher publisher;

//    public PrimaryAddress(Integer addressId, String street, String city, String state, String zipCode) {
//        this.addressId = addressId;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//    }
//
//    public PrimaryAddress() {
//    }
//
//    public Integer getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Integer addressId) {
//        this.addressId = addressId;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//    @Override
//    public String toString() {
//        return String.format("{AddressId: %d, Street: %s, City: %s, State: %s, ZipCode: %s}"
//                , addressId, street, city, state, zipCode);
//    }

    @Override
    public String toString() {
        return "PrimaryAddress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
