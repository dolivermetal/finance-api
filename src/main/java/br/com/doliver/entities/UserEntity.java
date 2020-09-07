package br.com.doliver.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @Column(name = "user_id", scale = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private BigInteger userId;

    @Column(name = "name", length = 100, nullable = false)
    @Getter
    private String name;

    @Column(name = "login", length = 100, nullable = false)
    @Getter
    private String login;

    @Column(name = "password", length = 100, nullable = false)
    @Getter
    private String password;

    @Column(name = "status", nullable = false)
    @Getter
    private boolean status = true;
}
