package br.com.doliver.resources;

import br.com.doliver.forms.StatementForm;
import br.com.doliver.forms.UserForm;
import br.com.doliver.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/statement", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class StatementResource {

    @Autowired
    private StatementService statementService;

    @PostMapping("/create")
    public ResponseEntity create (@RequestBody final StatementForm form) {
        try {
            final StatementForm response = statementService.create(form);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(form);
        }
    }

    @GetMapping("/list/accountId")
    public ResponseEntity listByAccountId(@PathVariable final BigInteger accountId) {
        List<StatementForm> statements = statementService.listByAccountId(accountId);
        return ResponseEntity.ok().body(statements);
    }
}
