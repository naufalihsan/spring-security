package id.codecamp.security.filter;

import jakarta.servlet.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Logger;

public class AuthoritiesLoggingAfterFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated()) {
            logger.info(MessageFormat.format("User {0} is authenticated and has authorities {1}", authentication.getName(), authentication.getAuthorities()));
        }

        chain.doFilter(request, response);
    }
}
