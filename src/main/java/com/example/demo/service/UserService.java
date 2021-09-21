package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import com.example.demo.model.User;
import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User find(Long id);

    User save(User user);

    User update(User user);

    void delete(Long id);

}
