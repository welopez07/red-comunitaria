package com.integrador.red_comunitaria.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String name;
    private LocalDate date;

    private String category;
    private Double minInversion;
    private String detailsInversion;
    @Enumerated(EnumType.STRING)
    private EstadoProyecto estado;

    @ManyToOne // Relación con el emprendedor (creador del proyecto)
    @JoinColumn(name = "creador_id")
    private Usuario creador;
    @OneToMany(mappedBy = "proyecto") // Relación con solicitudes de inversión
    private List<SolicitudInversion> solicitudInversions;

    public Proyecto(int projectId, String name, LocalDate date, String category, Double minInversion, String detailsInversion, EstadoProyecto estado, Usuario creador, List<SolicitudInversion> solicitudInversions) {
        this.projectId = projectId;
        this.name = name;
        this.date = date;
        this.category = category;
        this.minInversion = minInversion;
        this.detailsInversion = detailsInversion;
        this.estado = estado;
        this.creador = creador;
        this.solicitudInversions = solicitudInversions;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMinInversion() {
        return minInversion;
    }

    public void setMinInversion(Double minInversion) {
        this.minInversion = minInversion;
    }

    public String getDetailsInversion() {
        return detailsInversion;
    }

    public void setDetailsInversion(String detailsInversion) {
        this.detailsInversion = detailsInversion;
    }

    public EstadoProyecto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public List<SolicitudInversion> getSolicitudInversions() {
        return solicitudInversions;
    }

    public void setSolicitudInversions(List<SolicitudInversion> solicitudInversions) {
        this.solicitudInversions = solicitudInversions;
    }
}
