package br.com.doliversilva.entities;

import br.com.doliversilva.types.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

@Entity
@NoArgsConstructor
public class StatementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statement_id", scale = 20, nullable = false)
    @Getter @Setter
    private BigInteger statementID;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    @Column(name = "amount", scale = 20, precision = 2, nullable = false)
    private BigDecimal amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_at")
    private Calendar date;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Category category;
}
