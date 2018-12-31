package com.ride_api.auth.service;

import com.ride_api.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
