package br.com.doliver.resources;

import br.com.doliver.excpetions.EntityNotFound;
import br.com.doliver.forms.UserForm;
import br.com.doliver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    @Autowired
    private UserService userService;

    // TODO: improve login security
    @PostMapping("/users/login")
    public ResponseEntity doLogin(@RequestHeader final String login,
                                  @RequestHeader final String password) {
        final boolean isValidated = userService.validateLogin(login, password);
        if (isValidated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody UserForm form) {
        final UserForm response = userService.create(form);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.badRequest().body(form);
        }
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity delete(@PathVariable BigInteger userId) {
        try {
            userService.delete(userId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFound e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity list() {
        try {
            List<UserForm> users = userService.listAll();
            return ResponseEntity.ok().body(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
