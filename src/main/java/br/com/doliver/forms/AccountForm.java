package br.com.doliver.forms;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.AccessType;
import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
public class AccountForm {

    @Getter
    private BigInteger accountId;

    @Getter
    private String alias;

    @Getter
    private AccessType accountType;

    @Getter
    private BigDecimal balance;

}
