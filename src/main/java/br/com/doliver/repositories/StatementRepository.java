package br.com.doliver.repositories;

import br.com.doliver.entities.AccountEntity;
import br.com.doliver.entities.StatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface StatementRepository extends JpaRepository<StatementEntity, BigInteger> {

    List<StatementEntity> findByAccount(AccountEntity account);

}
