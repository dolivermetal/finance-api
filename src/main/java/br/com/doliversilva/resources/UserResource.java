package br.com.doliversilva.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserResource {

    @PostMapping("/login")
    public void login() {

    }
}
