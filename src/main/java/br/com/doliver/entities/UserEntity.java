package br.com.doliver.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id", scale = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private BigInteger userID;

    @Column(name = "name", length = 100, nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "login", length = 100, nullable = false)
    @Getter @Setter
    private String login;

    @Column(name = "password", length = 100, nullable = false)
    @Getter @Setter
    private String password;

    @Column(name = "status", nullable = false)
    @Getter @Setter
    private boolean status = true;
}
