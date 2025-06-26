package com.bank.serviceuser.service;

import com.bank.serviceuser.dto.UsuarioRequestDTO;
import com.bank.serviceuser.dto.UsuarioResponseDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UsuarioResponseDTO createUser(UsuarioRequestDTO requestDTO);

    Optional<UsuarioResponseDTO> getUserById(Long id);

    List<UsuarioResponseDTO> getAllUsers();

    UsuarioResponseDTO updateUser(Long id, UsuarioRequestDTO requestDTO);

    void deleteUser(Long id);
}
