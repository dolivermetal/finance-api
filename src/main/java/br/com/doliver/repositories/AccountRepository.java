package br.com.doliver.repositories;

import br.com.doliver.entities.AccountEntity;
import br.com.doliver.entities.UserEntity;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface AccountRepository extends Repository<AccountEntity, BigInteger> {

}
