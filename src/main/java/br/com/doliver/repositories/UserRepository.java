package br.com.doliver.repositories;

import br.com.doliver.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

    @Query(value = "SELECT u from UserEntity u WHERE u.login = :login AND u.password = :password AND u.status = :status")
    UserEntity findByLoginAndPasswordAndStatus(@Param("login") String login, @Param("password") String password, @Param("status") boolean status);

}
