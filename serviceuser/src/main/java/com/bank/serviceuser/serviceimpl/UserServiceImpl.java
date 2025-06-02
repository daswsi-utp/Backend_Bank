package com.bank.serviceuser.serviceimpl;

import com.bank.serviceuser.model.Credencial;
import com.bank.serviceuser.model.Usuario;
import com.bank.serviceuser.repository.UserRepository;
import com.bank.serviceuser.service.UserService;
import com.bank.serviceuser.repository.CredentialRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CredentialRepository credentialRepository) {
        this.userRepository = userRepository;
        this.credentialRepository = credentialRepository;
    }

    @Override
    public Usuario createUser(Usuario user, String password) {
        user.setFechaCreacion(LocalDateTime.now());
        Usuario savedUser = userRepository.save(user);

        Credencial credential = Credencial.builder()
                .usuario(savedUser)
                .passwordHash(password) // sin encriptar
                .dosFactoresActivado(false)
                .ultimoLogin(null)
                .build();

        credentialRepository.save(credential);
        return savedUser;
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
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setNombre(updatedUser.getNombre());
                    existingUser.setApellidoPaterno(updatedUser.getApellidoPaterno());
                    existingUser.setApellidoMaterno(updatedUser.getApellidoMaterno());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setTelefono(updatedUser.getTelefono());
                    existingUser.setDni(updatedUser.getDni());
                    existingUser.setDepartamento(updatedUser.getDepartamento());
                    existingUser.setProvincia(updatedUser.getProvincia());
                    existingUser.setDistrito(updatedUser.getDistrito());
                    existingUser.setDireccion(updatedUser.getDireccion());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
