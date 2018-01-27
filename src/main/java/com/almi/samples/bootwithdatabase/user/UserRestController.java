package com.almi.samples.bootwithdatabase.user;

import com.almi.samples.bootwithdatabase.utils.ErrorJson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Almi on 27-Jan-18.
 */
@Slf4j
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/api/users/locked")
    public Iterable<User> getLockedUsers() {
        return userService.getLockedUsers();
    }

    @PostMapping("/api/users/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        // add RxJava for more readable code here to get rid of try-catch block
        try {
            userService.registerUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ErrorJson.builder().message(e.getMessage()).build());
        }
    }
}
