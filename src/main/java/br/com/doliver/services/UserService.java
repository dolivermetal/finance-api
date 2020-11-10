package br.com.doliver.services;

import br.com.doliver.entities.UserEntity;
import br.com.doliver.excpetions.EntityNotFound;
import br.com.doliver.forms.UserForm;
import br.com.doliver.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Repository
public class UserService {


    @Autowired
    private UserRepository repository;

    public boolean validateLogin(String login, String password) {
        log.info(String.format("Attemp of login from user %s", login));
        final UserEntity user = repository.findByLoginAndPasswordAndStatus(login, password, true);
        if (user == null) {
            return false;
        }
        log.info(String.format("User %s logged successfuly", user.getLogin()));
        return true;
    }

    @Transactional
    public void delete(BigInteger userId) throws EntityNotFound, Exception {
        try {
            final UserEntity user = repository.getOne(userId);
            if (user == null) {
                throw new EntityNotFound(String.format("User not found: %d", userId));
            }

            user.setStatus(false);
            user.setUpdatedAt(Calendar.getInstance());
            repository.save(user);
        } catch (Exception e) {
            log.error(String.format("Error to disable user %d", userId), e);
            throw new Exception(e);
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
        log.info(String.format("New user registered. user{id:%d, login:%s}", user.getUserId(), user.getLogin()));
        return formBuilder(user);
    }

    public List<UserForm> listAll() {
        List<UserEntity> all = repository.findAll();
        List<UserForm> forms = new ArrayList<>();
        all.forEach(user -> forms.add(formBuilder(user)));
        return forms;

    }

    private UserForm formBuilder(UserEntity user) {
        return UserForm.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .login(user.getLogin())
                .build();
    }
}
