package br.com.doliver.forms;

import br.com.doliver.types.Category;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

@Builder
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
