package br.com.doliver.repositories;

import br.com.doliver.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

    UserEntity findByLoginAndPassword(String login, String password);

}
