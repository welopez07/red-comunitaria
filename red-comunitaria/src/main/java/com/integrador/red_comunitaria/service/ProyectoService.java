package com.integrador.red_comunitaria.service;

import com.integrador.red_comunitaria.model.EstadoProyecto;
import com.integrador.red_comunitaria.model.Proyecto;
import com.integrador.red_comunitaria.repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private IProyectoRepository proyectoRepository;

    public List<Proyecto> listarProyectos() {
        return proyectoRepository.findAll();
    }

    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto actualizarProyecto(Long id, Proyecto proyectoDetalles) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        proyecto.setName(proyectoDetalles.getName());
        proyecto.setDate(proyectoDetalles.getDate());
        proyecto.setCategory(proyectoDetalles.getCategory());
        proyecto.setMinInversion(proyectoDetalles.getMinInversion());
        proyecto.setDetailsInversion(proyectoDetalles.getDetailsInversion());
        proyecto.setEstado(proyectoDetalles.getEstado());
        proyecto.setCreador(proyectoDetalles.getCreador());
        return proyectoRepository.save(proyecto);
    }

    public Proyecto obtenerProyectoPorEstado(EstadoProyecto estado) {
        return proyectoRepository.findByEstado(estado).stream().findFirst().orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id).orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
