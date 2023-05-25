package com.app.fontexplorer.Entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
public class EstadistiquesFont {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Long idEstadistica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "id_fuente")
    private Fuente fuente;

    @Column(name = "calificacion")
    private float calificacion;

    @Column(name = "comentarios")
    private String comentarios;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public EstadistiquesFont () {}

    public EstadistiquesFont(Fuente fuente, float calificacion, String comentarios, Usuario usuario) {
        this.fuente = fuente;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    public Long getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Long idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    @JsonProperty("fuente")
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
    @JsonProperty("usuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
