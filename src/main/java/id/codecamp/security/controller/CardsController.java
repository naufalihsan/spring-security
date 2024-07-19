package id.codecamp.security.controller;

import id.codecamp.security.model.Cards;
import id.codecamp.security.model.Customer;
import id.codecamp.security.repository.CardsRepository;
import id.codecamp.security.repository.CustomerRepository;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam String email) {
        final List<Customer> customers = customerRepository.findByEmail(email);
        if (customers != null && !customers.isEmpty()) {
            return cardsRepository.findByCustomerId(customers.getFirst().getId());
        }
        return Collections.emptyList();
    }

}