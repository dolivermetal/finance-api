package br.com.doliver.entities;

import br.com.doliver.types.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

@Entity
@SuperBuilder
@NoArgsConstructor
public class StatementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statement_id", scale = 20, nullable = false)
    @Getter @Setter
    private BigInteger statementId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Getter @Setter
    private AccountEntity account;

    @Column(name = "description", length = 100, nullable = false)
    @Getter @Setter
    private String description;

    @Column(name = "amount", scale = 20, precision = 2, nullable = false)
    @Getter @Setter
    private BigDecimal amount;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Getter @Setter
    private Category category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_at")
    @Getter @Setter
    private Calendar createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "updated_at")
    @Getter @Setter
    private Calendar updatedAt;

}
