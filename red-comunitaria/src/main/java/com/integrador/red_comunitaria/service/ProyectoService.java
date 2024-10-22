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

    public List<Proyecto> listarProyectosPorEstado(EstadoProyecto estado) {
        return proyectoRepository.findByEstado(estado);
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }


}
