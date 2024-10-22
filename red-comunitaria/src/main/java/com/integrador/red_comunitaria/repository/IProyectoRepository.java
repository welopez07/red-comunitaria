package com.integrador.red_comunitaria.repository;

import com.integrador.red_comunitaria.model.EstadoProyecto;
import com.integrador.red_comunitaria.model.Proyecto;
import com.integrador.red_comunitaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByCreador(Usuario creador);
    List<Proyecto> findByEstado(EstadoProyecto estado);

}
