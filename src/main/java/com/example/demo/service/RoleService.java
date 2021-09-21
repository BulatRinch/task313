package com.example.demo.service;

import com.example.demo.model.Role;

public interface RoleService {

    Iterable<Role> findAllRoles();
    Role add(Role role);
}
