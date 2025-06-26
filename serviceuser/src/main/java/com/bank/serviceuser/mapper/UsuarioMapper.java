package com.bank.serviceuser.mapper;

import com.bank.serviceuser.dto.UsuarioRequestDTO;
import com.bank.serviceuser.dto.UsuarioResponseDTO;
import com.bank.serviceuser.model.TipoUsuario;
import com.bank.serviceuser.model.Usuario;

import java.sql.Timestamp;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setTipo(TipoUsuario.valueOf(dto.getTipo()));
        usuario.setNombre(dto.getNombre());
        usuario.setApePaterno(dto.getApePaterno());
        usuario.setApeMaterno(dto.getApeMaterno());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setDni(dto.getDni());
        usuario.setDepartamento(dto.getDepartamento());
        usuario.setProvincia(dto.getProvincia());
        usuario.setDistrito(dto.getDistrito());
        usuario.setDireccion(dto.getDireccion());
        usuario.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        return usuario;
    }

    public static UsuarioResponseDTO toDto(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setTipo(usuario.getTipo().name());
        dto.setNombre(usuario.getNombre());
        dto.setApePaterno(usuario.getApePaterno());
        dto.setApeMaterno(usuario.getApeMaterno());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());
        dto.setDni(usuario.getDni());
        dto.setDepartamento(usuario.getDepartamento());
        dto.setProvincia(usuario.getProvincia());
        dto.setDistrito(usuario.getDistrito());
        dto.setDireccion(usuario.getDireccion());
        dto.setFechaCreacion(usuario.getFechaCreacion().toString());
        return dto;
    }
}
