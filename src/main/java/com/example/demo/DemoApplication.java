package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("home")
    public String goHome() {
        System.out.println(99);
        User user = userRepository.findById(1).get();
        System.out.println(user);
        return "home";
    }
    @GetMapping("home/{id}")
    public User goHome(@PathVariable("id") Integer id) {

        Optional<User> user = userRepository.findById(id);
        System.out.println(user);
        return user.get();
    }
}
