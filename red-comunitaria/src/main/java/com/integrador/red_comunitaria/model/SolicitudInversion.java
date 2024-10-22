package com.integrador.red_comunitaria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class SolicitudInversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne // Relación con el proyecto
    @JoinColumn(name = "proyecto_id")
    @JsonBackReference(value = "proyecto-solicitud")
    private Proyecto proyecto;

    @ManyToOne // Relación con el usuario (inversionista)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference(value = "usuario-solicitud")
    private Usuario inversionista;
    private String message;
    private LocalDate date;
    private Double amount;

    public SolicitudInversion() {}

    public SolicitudInversion(int id, Proyecto proyecto, Usuario inversionista, String message, LocalDate date, Double amount) {
        this.id = id;
        this.proyecto = proyecto;
        this.inversionista = inversionista;
        this.message = message;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getInversionista() {
        return inversionista;
    }

    public void setInversionista(Usuario inversionista) {
        this.inversionista = inversionista;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
