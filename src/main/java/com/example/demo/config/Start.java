package com.example.demo.config;

import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.model.Role;
import com.example.demo.model.User;

import java.util.HashSet;

@Configuration
public class Start {

    private static final Logger log = LoggerFactory.getLogger(Start.class);

    @Bean
    CommandLineRunner initDatabase(RoleService roleService,
                                   UserService userService) {
        return args -> {
            Role roleAdmin = new Role("ROLE_ADMIN");
            Role roleUser = new Role("ROLE_USER");

            log.info("Preloading " + roleService.add(roleAdmin));
            log.info("Preloading " + roleService.add(roleUser));

            log.info("Preloading " + userService.save(new User("Иван", "Сергеев", 25, "admin@mail.com",
                   "admin",
                    new HashSet<>() {{
                        add(roleAdmin);
                        add(roleUser);
                    }})));
            log.info("Preloading " + userService.save(new User("Сергей", "Николаев", 32, "user@mail.com",
                    "user",
                    new HashSet<>() {{
                        add(roleUser);
                    }})));
        };
    }
}
