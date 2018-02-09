package com.butchjgo.simplecas.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"user_email"}))
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_email")
    String email;

    @Column(name = "user_password")
    String password;

    /*@OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    UserProfile profile;*/

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
