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
    @GeneratedValue
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

}
