package com.almi.samples.bootwithdatabase.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Almi on 27-Jan-18.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Iterable<User> getLockedUsers() {
        return userRepository.findAllByLockedTrue();
    }

    public void registerUser(User user) throws Exception {
        if(userRepository.hasUsersWithMail(user.getEmail())) {
            throw new IllegalArgumentException("User with specified e-mail already exists");
        }

        userRepository.save(user);
    }
}
