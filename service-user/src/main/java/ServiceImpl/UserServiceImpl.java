package com.bank.serviceuser.service.impl;

import com.bank.serviceuser.model.Usuario;
import com.bank.serviceuser.repository.UserRepository;
import com.bank.serviceuser.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<Usuario> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Usuario> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> getUserByDni(String dni) {
        return userRepository.findByDni(dni);
    }

    @Override
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Usuario updateUser(Long id, Usuario updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setNombre(updatedUser.getNombre());
            user.setApePaterno(updatedUser.getApePaterno());
            user.setApeMaterno(updatedUser.getApeMaterno());
            user.setEmail(updatedUser.getEmail());
            user.setTelefono(updatedUser.getTelefono());
            user.setDni(updatedUser.getDni());
            user.setDepartamento(updatedUser.getDepartamento());
            user.setProvincia(updatedUser.getProvincia());
            user.setDistrito(updatedUser.getDistrito());
            user.setDireccion(updatedUser.getDireccion());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
