package org.example.Services;


import org.example.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long Id);

    User getUser(Long Id);

    List<User> getAllUsers();

    void deleteAllUsers();
}
