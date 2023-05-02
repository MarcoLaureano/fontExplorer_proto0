package com.app.fontexplorer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@Entity
public class EstadistiquesFont {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Long idEstadistica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_fuente")
    private Fuente fuente;

    @Column(name = "calificacion")
    private float calificacion;

    @Column(name = "comentarios")
    private String comentarios;

    public EstadistiquesFont () {}

    public EstadistiquesFont( Fuente fuente, float calificacion, String comentarios) {
        this.fuente = fuente;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
    }

    public Long getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Long idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
