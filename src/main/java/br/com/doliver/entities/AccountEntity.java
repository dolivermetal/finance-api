package br.com.doliver.entities;

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
public class AccountEntity {

    @Id
    @Column(name = "account_id", scale = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private BigInteger accountID;

    @Column(name = "alias", length = 100)
    @Getter @Setter
    private String alias;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Getter @Setter
    private AccessType accountType;

    @Column(name = "balance", nullable = false, scale = 10, precision = 2)
    @Getter @Setter
    private BigDecimal balance;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "created_at")
    @Getter @Setter
    private Calendar createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "updated_at")
    @Getter @Setter
    private Calendar updatedAt;

}
