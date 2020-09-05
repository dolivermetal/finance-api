package br.com.doliversilva.entities;

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
    @Getter @Setter
    private BigInteger accountID;

    @Column(name = "alias", length = 100)
    private String alias;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Getter @Setter
    private AccessType accountType;

    @Column(name = "balance", nullable = false, scale = 10, precision = 2)
    @Getter @Setter
    private BigDecimal balance;

}
