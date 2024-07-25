package me.dio.domain.repository;

import me.dio.domain.model.User;

import java.util.Optional;

public interface CustomUserRepository {
    Optional<User> update(Long id, User userToUpdate);
}
