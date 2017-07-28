package br.com.doliver.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/clients")
public class ClientResource {

    @GetMapping
    public ResponseEntity getClient() {
        return ResponseEntity.ok().build();
    }
}