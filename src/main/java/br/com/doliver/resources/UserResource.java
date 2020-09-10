package br.com.doliver.resources;

import br.com.doliver.forms.UserForm;
import br.com.doliver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity doLogin(@RequestHeader final String login,
                                  @RequestHeader final String password) {
        final boolean isValidated = userService.validateLogin(login, password);
        if (isValidated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserForm form) {
        final UserForm response = userService.create(form);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.badRequest().body(form);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity delete(@PathVariable BigInteger userId) {
        try {
            userService.delete(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
