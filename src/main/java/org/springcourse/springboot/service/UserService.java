package org.springcourse.springboot.service;

import org.springcourse.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void delete(Long id);
    void update(User user);
}
