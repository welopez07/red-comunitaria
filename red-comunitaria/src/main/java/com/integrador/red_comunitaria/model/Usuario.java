package com.integrador.red_comunitaria.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false)
    private String documentNumber;
    private String name;
    private String lastName;
    private String cellPhone;
    private String email;
    @Enumerated(EnumType.STRING)
    private RolUsuario rol;
    @OneToMany(mappedBy = "creador")// Relación con proyectos (para emprendedores)
    private List<Proyecto> proyectos;
    @OneToMany(mappedBy = "inversionista") // Relación con solicitudes de inversión (para inversionistas)
    private List<SolicitudInversion> solicitudInversions;

    public Usuario(Long userId, String documentNumber, String name, String lastName, String cellPhone, String email, RolUsuario rol, List<Proyecto> proyectos, List<SolicitudInversion> solicitudInversions) {
        this.userId = userId;
        this.documentNumber = documentNumber;
        this.name = name;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
        this.email = email;
        this.rol = rol;
        this.proyectos = proyectos;
        this.solicitudInversions = solicitudInversions;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<SolicitudInversion> getSolicitudInversions() {
        return solicitudInversions;
    }

    public void setSolicitudInversions(List<SolicitudInversion> solicitudInversions) {
        this.solicitudInversions = solicitudInversions;
    }
}
