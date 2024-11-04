package com.integrador.red_comunitaria.controller;

import com.integrador.red_comunitaria.model.SolicitudInversion;
import com.integrador.red_comunitaria.service.SolicitudInversionService;
import com.integrador.red_comunitaria.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/solicitudes-inversion")
public class SolicitudInversionController {

    @Autowired
    private SolicitudInversionService solicitudInversionService;

    @PostMapping
    public ResponseEntity<SolicitudInversion> crearSolicitud(@RequestBody SolicitudInversion solicitudInversion) {
        try {
            SolicitudInversion nuevaSolicitud = solicitudInversionService.crearSolicitudInversion(solicitudInversion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSolicitud);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<SolicitudInversion>> listarSolicitudes() {
        try {
            List<SolicitudInversion> solicitudes = solicitudInversionService.listarSolicitudes();
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{inversionistaId}/solicitudes")
    public ResponseEntity<List<SolicitudInversion>> listarSolicitudesPorInversionista(@PathVariable Long inversionistaId) {
        try {
            Usuario inversionista = new Usuario();
            inversionista.setUserId(inversionistaId);
            List<SolicitudInversion> solicitudes = solicitudInversionService.listarSolicitudesPorInversionista(inversionista);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudInversion> obtenerSolicitudPorId(@PathVariable Long id) {
        try {
            SolicitudInversion solicitudInversion = solicitudInversionService.obtenerSolicitudPorId(id);
            return ResponseEntity.ok(solicitudInversion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudInversion> actualizarSolicitudInversion(@PathVariable Long id, @RequestBody SolicitudInversion solicitudInversionDetalles) {
        try {
            SolicitudInversion solicitudInversionActualizada = solicitudInversionService.actualizarSolicitudInversion(id, solicitudInversionDetalles);
            return ResponseEntity.ok(solicitudInversionActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarSolicitudInversion(@PathVariable Long id) {
        try {
            solicitudInversionService.eliminarSolicitudInversion(id);
            return ResponseEntity.ok("Solicitud de inversión eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la solicitud de inversión");
        }
    }



}
