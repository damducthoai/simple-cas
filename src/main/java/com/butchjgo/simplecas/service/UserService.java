package com.butchjgo.simplecas.service;

import com.butchjgo.simplecas.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> create(User user);

    void delete(User user);

    void delete(long userId);
}
