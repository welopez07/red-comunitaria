package com.integrador.red_comunitaria.service;

import com.integrador.red_comunitaria.model.SolicitudInversion;
import com.integrador.red_comunitaria.model.Usuario;
import com.integrador.red_comunitaria.repository.ISolicitudInversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudInversionService {

    @Autowired
    private ISolicitudInversionRepository solicitudInversionRepository;

    public List<SolicitudInversion> listarSolicitudes() {
        return solicitudInversionRepository.findAll();
    }

    public SolicitudInversion crearSolicitudInversion(SolicitudInversion solicitudInversion) {
        return solicitudInversionRepository.save(solicitudInversion);
    }

    public List<SolicitudInversion> listarSolicitudesPorInversionista(Usuario inversionista) {
        return solicitudInversionRepository.findByInversionista(inversionista);
    }

}
