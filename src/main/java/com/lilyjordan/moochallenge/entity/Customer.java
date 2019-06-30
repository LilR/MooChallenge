package com.lilyjordan.moochallenge.entity;

/**
 * Created by Lily on 30/06/2019.
 */


import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "First_Name", length = 32, nullable = false)
    private String firstName;

    @Column(name = "Surname", length = 32, nullable = false)
    private String surname;

    @Column(name = "Phone_Number", length = 32, nullable = false)
    private String phoneNumber;

    @Column(name = "Email_Address", length = 64, nullable = false)
    private String emailAddress;

    @Column(name = "PostalAddress", length = 256, nullable = false)
    private String postalAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}