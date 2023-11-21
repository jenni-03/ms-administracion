package com.administracion.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tabla")
public class Tabla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "problema")
    private Problema problema;
}
