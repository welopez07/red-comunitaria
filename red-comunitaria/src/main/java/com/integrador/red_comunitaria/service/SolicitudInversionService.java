package com.integrador.red_comunitaria.service;

import com.integrador.red_comunitaria.dto.SolicitudInversionDTO;
import com.integrador.red_comunitaria.model.Proyecto;
import com.integrador.red_comunitaria.model.RolUsuario;
import com.integrador.red_comunitaria.model.SolicitudInversion;
import com.integrador.red_comunitaria.model.Usuario;
import com.integrador.red_comunitaria.repository.IProyectoRepository;
import com.integrador.red_comunitaria.repository.ISolicitudInversionRepository;
import com.integrador.red_comunitaria.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudInversionService {

    @Autowired
    private ISolicitudInversionRepository solicitudInversionRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IProyectoRepository proyectoRepository;

    public List<SolicitudInversion> listarSolicitudes() {
        return solicitudInversionRepository.findAll();
    }
    public SolicitudInversion crearSolicitud(SolicitudInversionDTO solicitudDTO) {
        // Obtener y validar usuario por número de documento
        Usuario inversionista = usuarioRepository.findByDocumentNumber(solicitudDTO.getDocumentoIdentidad())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el documento: " + solicitudDTO.getDocumentoIdentidad()));

        // Validar si el usuario es un inversionista
        System.out.println("Validando rol del usuario: " + inversionista.getRol());
        if (inversionista.getRol() != RolUsuario.INVERSIONISTA) {
            String mensaje = "El usuario con documento " + solicitudDTO.getDocumentoIdentidad() +
                    " no está registrado como inversionista. Rol actual: " + inversionista.getRol();
            System.out.println(mensaje);
            throw new RuntimeException(mensaje);
        }

        // Si llegamos aquí, el usuario es un inversionista válido
        System.out.println("Usuario validado como inversionista");

        // Validar proyecto
        Proyecto proyecto = proyectoRepository.findById(solicitudDTO.getProyectoId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        // Crear nueva solicitud
        SolicitudInversion nuevaSolicitud = new SolicitudInversion();
        nuevaSolicitud.setProyecto(proyecto);
        nuevaSolicitud.setInversionista(inversionista);
        nuevaSolicitud.setMessage(solicitudDTO.getMessage());
        nuevaSolicitud.setDate(solicitudDTO.getDate());
        nuevaSolicitud.setAmount(solicitudDTO.getAmount());

        System.out.println("Creando nueva solicitud de inversión para el proyecto: " + proyecto.getProjectId());

        return solicitudInversionRepository.save(nuevaSolicitud);
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
