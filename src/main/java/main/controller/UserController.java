package main.controller;

import main.model.User;
import main.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody User user){
        registrationService.signUp(user);
    }

    @GetMapping("test")
    public String test(){
        return "Test is working";
    }

}
