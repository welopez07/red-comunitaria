package com.integrador.red_comunitaria.repository;

import com.integrador.red_comunitaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByDocumentNumber(String documentNumber);
}
