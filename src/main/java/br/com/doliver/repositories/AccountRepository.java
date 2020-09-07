package br.com.doliver.repositories;

import br.com.doliver.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountRepository extends JpaRepository<AccountEntity, BigInteger> {

}
