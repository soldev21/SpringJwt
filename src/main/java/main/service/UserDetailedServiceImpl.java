package main.service;

import main.model.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("RegistrationService")
public class UserDetailedServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = repository.findByUsername(s);

        if (user == null) throw new UsernameNotFoundException(s);
        return new org.springframework.security.core.userdetails.User(user.getUsername()
                ,user.getPassword()
                ,Collections.emptyList());
    }
}
