package com.bank.serviceuser.service;

import com.bank.serviceuser.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Usuario createUser(Usuario user);
    Optional<Usuario> getUserById(Long id);
    Optional<Usuario> getUserByEmail(String email);
    Optional<Usuario> getUserByDni(String dni);
    List<Usuario> getAllUsers();
    Usuario updateUser(Long id, Usuario updatedUser);
    void deleteUser(Long id);
}