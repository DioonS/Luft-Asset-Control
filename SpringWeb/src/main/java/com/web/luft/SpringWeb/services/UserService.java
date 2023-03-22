package com.web.luft.SpringWeb.services;

import com.web.luft.SpringWeb.exception.DuplicateEmailException;
import com.web.luft.SpringWeb.repository.AdministradoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AdministradoresRepo administradoresRepo;

    public void createUser(String email, String senha) throws DuplicateEmailException {
        if (administradoresRepo.existsByEmail(email)) {
            throw new DuplicateEmailException("E-mail já cadastrado!");
        }
    }
}
