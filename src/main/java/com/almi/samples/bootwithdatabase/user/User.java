package com.almi.samples.bootwithdatabase.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Almi on 27-Jan-18.
 */
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private long id;

    @Column(name = "user_name", length = 50)
    private String name;

    @Column(name = "user_surname", length = 50)
    private String surname;

    @Column(name = "user_mail", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "user_password", nullable = false, length = 100)
    private String password;

    @Column(name = "user_enabled", nullable = false)
    private boolean enabled;

    @Column(name = "user_credentials_expired", nullable = false)
    private boolean credentialsExpired;

    @Column(name = "user_locked", nullable = false)
    private boolean locked;

}
