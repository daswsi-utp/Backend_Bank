package com.bank.serviceuser.serviceimpl;

import com.bank.serviceuser.dto.UsuarioRequestDTO;
import com.bank.serviceuser.dto.UsuarioResponseDTO;
import com.bank.serviceuser.mapper.UsuarioMapper;
import com.bank.serviceuser.model.Usuario;
import com.bank.serviceuser.repository.UserRepository;
import com.bank.serviceuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UsuarioResponseDTO createUser(UsuarioRequestDTO requestDTO) {
        Usuario user = UsuarioMapper.toEntity(requestDTO);
        Usuario savedUser = userRepository.save(user);
        return UsuarioMapper.toDto(savedUser);
    }

    @Override
    public Optional<UsuarioResponseDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UsuarioMapper::toDto);
    }

    @Override
    public List<UsuarioResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO updateUser(Long id, UsuarioRequestDTO requestDTO) {
        return userRepository.findById(id)
                .map(existing -> {
                    Usuario updated = UsuarioMapper.toEntity(requestDTO);
                    updated.setId(existing.getId());
                    return UsuarioMapper.toDto(userRepository.save(updated));
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        userRepository.deleteById(id);
    }
}
