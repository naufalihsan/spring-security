package id.codecamp.security.controller;

import id.codecamp.security.model.Customer;
import id.codecamp.security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private CustomerRepository customerRepository;


    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        final List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if (customers.isEmpty()) {
            return null;
        }
        return customers.getFirst();
    }
}
