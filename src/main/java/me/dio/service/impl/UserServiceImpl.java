package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(@Lazy UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User update(Long id, User userToUpdate) {
        return (User) userRepository.update(id, userToUpdate).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void delete(Long id) {
         userRepository.deleteById(id);
    }

}