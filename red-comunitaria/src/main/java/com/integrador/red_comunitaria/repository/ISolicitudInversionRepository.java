package com.integrador.red_comunitaria.repository;

import com.integrador.red_comunitaria.model.Proyecto;
import com.integrador.red_comunitaria.model.SolicitudInversion;
import com.integrador.red_comunitaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISolicitudInversionRepository extends JpaRepository<SolicitudInversion, Long> {

    List<SolicitudInversion> findByInversionista(Usuario inversionista);
    List<SolicitudInversion> findByProyecto(Proyecto proyecto);


}
