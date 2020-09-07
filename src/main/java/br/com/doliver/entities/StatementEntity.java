package br.com.doliver.entities;

import br.com.doliver.types.Category;
import lombok.Builder;
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
@Builder
public class StatementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statement_id", scale = 20, nullable = false)
    @Getter
    private BigInteger statementId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Getter
    private AccountEntity account;

    @Column(name = "description", length = 100, nullable = false)
    @Getter
    private String description;

    @Column(name = "amount", scale = 20, precision = 2, nullable = false)
    @Getter
    private BigDecimal amount;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Getter
    private Category category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "created_at")
    @Getter
    private Calendar createdAt;
}
