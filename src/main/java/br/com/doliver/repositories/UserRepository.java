package br.com.doliver.repositories;

import br.com.doliver.entities.UserEntity;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface UserRepository extends Repository<UserEntity, BigInteger> {

    UserEntity findByLoginAndPassword(String login, String password);

}
