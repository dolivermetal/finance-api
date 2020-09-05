package br.com.doliversilva.repositories;

import br.com.doliversilva.entities.UserEntity;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface UserRepository extends Repository<UserEntity, BigInteger> {

    UserEntity findByLoginAndPassword(String login, String password);

}
