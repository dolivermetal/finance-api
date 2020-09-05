package br.com.doliver.repositories;

import br.com.doliver.entities.StatementEntity;
import br.com.doliver.entities.UserEntity;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface StatementRepository extends Repository<StatementEntity, BigInteger> {

}
