package br.com.doliver.services;

import br.com.doliver.entities.UserEntity;
import br.com.doliver.forms.UserForm;
import br.com.doliver.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Calendar;

@Repository
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    public boolean validateLogin(String login, String password) {
        logger.info(String.format("Tentativa de login do usuário $s", login));
        final UserEntity user = repository.findByLoginAndPassword(login, password);
        if (user != null) {
            return false;
        }
        logger.info(String.format("Usuário %s logado com sucesso", user.getLogin()));
        return true;
    }

    public boolean delete(BigInteger userId) {
        try {
            final UserEntity user = repository.getOne(userId);
            user.setStatus(false);
            user.setUpdatedAt(Calendar.getInstance());
            repository.save(user);
            return true;
        } catch (Exception e) {
            logger.error(String.format("Erro ao inativar usuário $d", userId), e);
            return false;
        }
    }

    public UserForm create(UserForm form) {
        UserEntity user = UserEntity.builder()
                .name(form.getName())
                .login(form.getLogin())
                .password(form.getPassword())
                .status(true)
                .createdAt(Calendar.getInstance())
                .updatedAt(Calendar.getInstance())
                .build();
        user = repository.save(user);
        logger.info(String.format("Novo usuário cadastrado. user { id: $d, login : %s }", user.getUserId(), user.getLogin()));
        return UserForm.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .login(user.getLogin())
                .build();
    }
}
