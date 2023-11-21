package com.administracion.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String descripcion;

    private String docente;

    private String nombreBase;

    private boolean estado;

    @JsonIgnoreProperties("problema")
    @OneToMany(mappedBy = "problema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examen> examenes;

    @JsonIgnoreProperties("problema")
    @OneToMany(mappedBy = "problema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tabla> tablas;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;
}
