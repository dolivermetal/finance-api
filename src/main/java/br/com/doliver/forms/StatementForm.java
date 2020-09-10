package br.com.doliver.forms;

import br.com.doliver.types.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

@SuperBuilder
@NoArgsConstructor
public class StatementForm {

    @Getter
    private BigInteger statementId;

    @Getter
    private AccountForm account;

    @Getter
    private String description;

    @Getter
    private BigDecimal amount;

    @Getter
    private Category category;

    @Getter
    private Calendar createdAt;
}
