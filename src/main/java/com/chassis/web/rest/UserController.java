package com.chassis.web.rest;

import com.chassis.model.User;
import com.chassis.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {
    private UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        if (null == createdUser) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer with same name exits");
        } else {
            return createdUser;
        }
    }
    @GetMapping("/sortBySalary")
    public List<User> getSortedBySalary() {
        return userService.getSortedBySalary();
    }
    @GetMapping("/rsortBySalary")
    public List<User> getReverseSortedBySalary() {
        return userService.getReverseSortedBySalary();
    }
    @GetMapping("/sortByFname")
    public List<User> getSortedByFname() {
        return userService.getSortedByFname();
    }
    @PutMapping("/edit")
    public User updateByFNameLName(@RequestBody User requestUser) {
        User user = userService.updateByFNameLName(requestUser);
        if (null != user) {
            return user;
        } else {
            log.error("Cannot find user {}", requestUser);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
