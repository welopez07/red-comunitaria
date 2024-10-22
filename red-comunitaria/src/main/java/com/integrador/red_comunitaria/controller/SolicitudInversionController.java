package com.integrador.red_comunitaria.controller;

import com.integrador.red_comunitaria.model.SolicitudInversion;
import com.integrador.red_comunitaria.service.SolicitudInversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes-inversion")
public class SolicitudInversionController {

    @Autowired
    private SolicitudInversionService solicitudInversionService;

    @GetMapping
    public List<SolicitudInversion> listarSolicitudes() {
        return solicitudInversionService.listarSolicitudes();
    }

    @PostMapping
    public SolicitudInversion crearSolicitud(@RequestBody SolicitudInversion solicitudInversion) {
        return solicitudInversionService.crearSolicitudInversion(solicitudInversion);
    }

}
