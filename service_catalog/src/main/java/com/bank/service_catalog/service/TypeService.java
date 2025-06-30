package com.bank.service_catalog.service;

import com.bank.service_catalog.dto.TypeDTO;

import java.util.List;

public interface TypeService {
    List<TypeDTO> getAllTypes();
    TypeDTO getTypeById(Byte id);
    TypeDTO createType(TypeDTO typeDTO);
    TypeDTO updateType(Byte id, TypeDTO typeDTO);
    void deleteType(Byte id);
}
