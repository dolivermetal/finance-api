package br.com.doliversilva.services;

import br.com.doliversilva.entities.UserEntity;
import br.com.doliversilva.repositories.UserRepository;
import br.com.doliversilva.resources.HomeResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public boolean validateLogin(String login, String password) {
        logger.info(String.format("Tentativa de login do usuário $s", login));
        final UserEntity user = userRepository.findByLoginAndPassword(login, password);
        if (user != null) {
            return false;
        }
        logger.info(String.format("Usuário %s logado", user.getLogin()));
        return true;
    }
}
