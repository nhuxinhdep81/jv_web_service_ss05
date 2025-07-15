package com.tien.ss05.service;

import com.tien.ss05.model.entity.User;
import com.tien.ss05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(value = "user", key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @CacheEvict(value = "users", allEntries = true)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @CachePut(value = "user", key = "#id")
    @CacheEvict(value = "users", allEntries = true)
    public User updateUser(User user, Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        user.setId(id);
        return userRepository.save(user);
    }

    @CacheEvict(value = {"users", "user"}, allEntries = true)
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
