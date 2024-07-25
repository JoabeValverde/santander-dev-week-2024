package me.dio.service;

import me.dio.domain.model.User;

public interface UserService {
    User findById(Long id); //metodo que retorna um id

    User create(User userToCreate);
    User update(Long id, User userToUpdate);
    void delete(Long id);
}
