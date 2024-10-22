package com.integrador.red_comunitaria.repository;

import com.integrador.red_comunitaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByDocumentNumber(String documentNumber);
}
