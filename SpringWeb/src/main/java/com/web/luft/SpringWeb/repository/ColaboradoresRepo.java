package com.web.luft.SpringWeb.repository;

import com.web.luft.SpringWeb.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColaboradoresRepo extends JpaRepository<Colaborador, Integer> {
    boolean existsById(Integer id);
}
