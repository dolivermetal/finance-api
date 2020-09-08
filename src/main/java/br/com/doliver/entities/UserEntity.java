package br.com.doliver.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Calendar;

@Entity
@SuperBuilder
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id", scale = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private BigInteger userId;

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
    private boolean status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "created_at")
    @Getter @Setter
    private Calendar createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "updated_at")
    @Getter @Setter
    private Calendar updatedAt;
}
