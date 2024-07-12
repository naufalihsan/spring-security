package id.codecamp.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @GetMapping("/")
    public String sayWelcome() {
        return "Spring Application with Spring Security";
    }
}
