package main.service;

import main.Application;
import main.model.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository repository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signUp(User user){
        if (repository.findByUsername(user.getUsername())==null){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            repository.save(user);
        }
    }
}
