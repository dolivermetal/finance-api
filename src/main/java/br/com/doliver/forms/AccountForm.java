package br.com.doliver.forms;

import br.com.doliver.types.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;

@SuperBuilder
@NoArgsConstructor
public class AccountForm {

    @Getter
    private BigInteger accountId;

    @Getter
    private String alias;

    @Getter
    private AccountType accountType;

    @Getter
    private BigDecimal balance;

}
