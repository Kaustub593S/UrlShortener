package com.example.urlshort;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UrlsShortController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UrlService services;

    public UrlsShortController(UserRepository userRepository, PasswordEncoder passwordEncoder,UrlService services)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.services=services;
    }



    @PostMapping("/register")
    public String register(@RequestBody User user)
    {
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered Successfully";
    }

    @GetMapping("/{shortCode}")
    public String redirect(@PathVariable String shortCode)
    {
        String originalUrl = services.getOriginalUrl(shortCode);
        return "redirect:" + originalUrl;
    }


}
