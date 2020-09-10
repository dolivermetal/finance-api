package br.com.doliver.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@SuperBuilder
@NoArgsConstructor
public class UserForm {

    @Getter
    private BigInteger userId;

    @Getter
    private String name;

    @Getter
    private String login;

    @Getter
    private String password;
}
