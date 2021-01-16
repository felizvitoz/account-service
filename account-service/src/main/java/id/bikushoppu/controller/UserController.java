package id.bikushoppu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${db.uri}")
    private String dbUri;

    @GetMapping("/greeting")
    public String greeting() {
        return dbUri;
    }
}
