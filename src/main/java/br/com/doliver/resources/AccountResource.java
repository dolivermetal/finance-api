package br.com.doliver.resources;

import br.com.doliver.forms.AccountForm;
import br.com.doliver.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity create (@RequestBody final AccountForm form) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity list () {
        return ResponseEntity.ok().build();
    }
}
