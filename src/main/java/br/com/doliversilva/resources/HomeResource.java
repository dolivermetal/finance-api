package br.com.doliversilva.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    private static final Logger logger = LoggerFactory.getLogger(HomeResource.class);

    @GetMapping(path = "/")
    public String home(){
        return "home";
    }
}
