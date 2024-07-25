package me.dio.domain.repository.impl.CustomUserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.dio.domain.model.User;
import me.dio.domain.repository.CustomUserRepository;
import me.dio.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    @Lazy
    private UserRepository userRepository;

    @Override
    public Optional<User> update(Long id, User userToUpdate) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(userToUpdate.getName());
            existingUser.setCard(userToUpdate.getCard());
            existingUser.setAccount(userToUpdate.getAccount());
            entityManager.merge(existingUser);
            return existingUser;
        });
    }
}
