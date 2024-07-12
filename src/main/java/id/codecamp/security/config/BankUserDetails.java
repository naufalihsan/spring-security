package id.codecamp.security.config;

import id.codecamp.security.model.Customer;
import id.codecamp.security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankUserDetails implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName;
        String password;
        List<GrantedAuthority> authorities;
        List<Customer> customer = customerRepository.findByEmail(username);

        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else {
            userName = customer.getFirst().getEmail();
            password = customer.getFirst().getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getFirst().getRole()));
        }

        return new User(userName, password, authorities);
    }
}
