package com.ak.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by MacDuck on 11/2/16.
 */
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=4, message="Name must be between 4 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z]+$",message="Name must be alphabetic.")
    private String firstName;
    @Size(min=5, message="Username must be between 4 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z]+$",message="Second name must be alphabetic.")
    private String secondName;

    @Size(min=5, message="Username must be between 4 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z]+$",message="Third name must be alphabetic.")
    private String thirdName;

    @Size(min=5, message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",message="Login must be alphabetic.")
    private String mobilePhone;

    private String homePhone;
    private String addres;

    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}",
            message="Invalid email address.")
    private String email;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Contact() {
    }

    public Contact(String firstName, String secondName, String thirdName, String mobilePhone,
                   String homePhone, String addres, String email, User user) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.addres = addres;
        this.email = email;
        this.user = user;
    }

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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
