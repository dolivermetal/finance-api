package br.com.doliver.resources;

import br.com.doliver.forms.AccountForm;
import br.com.doliver.forms.UserForm;
import br.com.doliver.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity create (@RequestBody final AccountForm form) {
        final AccountForm response = accountService.create(form);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.badRequest().body(form);
        }
    }

    @GetMapping("/list")
    public ResponseEntity list () {
        List<AccountForm> response = accountService.listAll();
        return ResponseEntity.ok().body(response);
    }
}
