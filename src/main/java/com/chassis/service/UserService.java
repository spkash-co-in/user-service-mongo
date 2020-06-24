package com.chassis.service;

import com.chassis.model.User;
import com.chassis.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User addUser(User user) {
        User existsCustomer = userRepository.findByFNameAndLName(user.getFName(), user.getLName());
        if (existsCustomer!= null) {
            return null;
        }
        return userRepository.save(user);
    }
    public List<User> getSortedBySalary() {
        return userRepository.findAll().stream().sorted(Comparator.comparingLong(User::getSalary)).collect(Collectors.toList());
    }
    public List<User> getReverseSortedBySalary() {
        return userRepository.findAll().stream().sorted(Comparator.comparingLong(User::getSalary).reversed()).collect(Collectors.toList());
    }
    public List<User> getSortedByFname() {
        return userRepository.findAll().stream().sorted(Comparator.comparing(User::getFName)).collect(Collectors.toList());
    }
    public User updateByFNameLName(User requestUser) {
        User user = userRepository.findByFNameAndLName(requestUser.getFName(), requestUser.getLName());
        if (user != null) {
            user.setSalary(requestUser.getSalary());
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
