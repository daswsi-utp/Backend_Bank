/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.bank.serviceuser.service;

import com.bank.serviceuser.model.Credencial;

import java.util.Optional;

public interface CredentialService {
    Credencial createCredential(Credencial credencial);
    Optional<Credencial> getCredentialByUserId(Long userId);
}
