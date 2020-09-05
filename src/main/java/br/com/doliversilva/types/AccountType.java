package br.com.doliversilva.types;

import java.math.BigInteger;

public enum AccountType {

    BANK (1, "Bank"),

    CREDIT_CARD (2, "Credit Card"),
    ;

    AccountType(int i, String name) {
    }
}
