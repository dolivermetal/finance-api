package br.com.doliver.forms;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Builder
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
