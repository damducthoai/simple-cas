package com.butchjgo.simplecas.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_profile", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"}))
public class UserProfile {
    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "gender")
    Integer gender;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "middle_name")
    String middleName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "address")
    String address;

    @Column(name = "phone")
    String phone;

    @Column(name = "last_acive")
    Date lastAcive;

    @Column(name = "action_code")
    String actionCode;

    @Column(name = "status_code")
    Integer statusCode;
}
