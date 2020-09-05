package br.com.doliver.resources;

import br.com.doliver.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statement", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatementResource {

    @Autowired
    private StatementService statementService;
}
