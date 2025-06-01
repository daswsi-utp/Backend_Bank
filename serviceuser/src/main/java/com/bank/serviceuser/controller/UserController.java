package com.bank.serviceuser.controller;

import com.bank.serviceuser.dto.UserCreateDTO;
import com.bank.serviceuser.dto.UserResponseDTO;
import com.bank.serviceuser.model.Usuario;
import com.bank.serviceuser.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    // Crear usuario
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserCreateDTO dto) {
        Usuario user = modelMapper.map(dto, Usuario.class);
        Usuario saved = userService.createUser(user);
        UserResponseDTO response = modelMapper.map(saved, UserResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(modelMapper.map(user, UserResponseDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener usuario por email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(user -> ResponseEntity.ok(modelMapper.map(user, UserResponseDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener usuario por DNI
    @GetMapping("/dni/{dni}")
    public ResponseEntity<UserResponseDTO> getUserByDni(@PathVariable String dni) {
        return userService.getUserByDni(dni)
                .map(user -> ResponseEntity.ok(modelMapper.map(user, UserResponseDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers().stream()
                .map(user -> modelMapper.map(user, UserResponseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserCreateDTO dto) {
        Usuario updatedUser = modelMapper.map(dto, Usuario.class);
        Usuario saved = userService.updateUser(id, updatedUser);
        UserResponseDTO response = modelMapper.map(saved, UserResponseDTO.class);
        return ResponseEntity.ok(response);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
