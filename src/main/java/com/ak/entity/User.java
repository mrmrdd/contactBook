package com.ak.entity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
/**
 * Created by MacDuck on 11/2/16.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min=3, max=20,message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z]+$",message="Login must be alphabetic with no spaces")
    private String login;

    @Size(min=5, message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",message="Login must be alphanumeric")
    private String password;
    private String FIO;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Contact> phoneBook;

    public User() {
    }

    public User(String login, String password, String FIO) {
        this.login = login;
        this.password = password;
        this.FIO = FIO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public List<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }
}