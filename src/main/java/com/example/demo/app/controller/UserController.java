package com.example.demo.app.controller;

import com.example.demo.app.dto.AppUserDto;
import com.example.demo.app.entity.AppUser;
import com.example.demo.app.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0/user")
public class UserController {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public AppUserDto register(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = new AppUser(appUserDto.getUsername(), passwordEncoder.encode(appUserDto.getPassword()), "ROLE_USER");
        AppUser savedAppUser = appUserRepository.save(appUser);
        return AppUserDto.builder()
                .id(savedAppUser.getId())
                .username(savedAppUser.getUsername())
                .role(savedAppUser.getRole())
                .build();
    }
}
