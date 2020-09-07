package br.com.doliver.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
public class AccountEntity {

    @Id
    @Column(name = "account_id", scale = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private BigInteger accountID;

    @Column(name = "alias", length = 100)
    @Getter
    private String alias;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Getter
    private AccessType accountType;

    @Column(name = "balance", nullable = false, scale = 10, precision = 2)
    @Getter
    private BigDecimal balance;

}
