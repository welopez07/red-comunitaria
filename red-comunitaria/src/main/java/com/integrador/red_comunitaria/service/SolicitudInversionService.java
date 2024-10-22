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
    public SolicitudInversion obtenerSolicitudPorId(Long id) {
        return solicitudInversionRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitud de inversión no encontrada"));
    }
    public SolicitudInversion actualizarSolicitudInversion(Long id, SolicitudInversion solicitudInversionDetalles) {
        SolicitudInversion solicitudInversion = solicitudInversionRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitud de inversión no encontrada"));
        solicitudInversion.setProyecto(solicitudInversionDetalles.getProyecto());
        solicitudInversion.setInversionista(solicitudInversionDetalles.getInversionista());
        solicitudInversion.setMessage(solicitudInversionDetalles.getMessage());
        solicitudInversion.setDate(solicitudInversionDetalles.getDate());
        solicitudInversion.setAmount(solicitudInversionDetalles.getAmount());
        return solicitudInversionRepository.save(solicitudInversion);
    }
    public void eliminarSolicitudInversion(Long id) {
        solicitudInversionRepository.deleteById(id);
    }
    public List<SolicitudInversion> listarSolicitudesPorInversionista(Usuario inversionista) {
        return solicitudInversionRepository.findByInversionista(inversionista);
    }

}
