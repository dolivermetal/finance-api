package br.com.doliver.resources;

import br.com.doliver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
