package com.curso.springM.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "direcciones")
@Getter
@Setter
public class Direcciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private Long direccionId;

    @Column(name = "Calle", length = 100, nullable = false)
    private String calle;

    @Column(name = "ciudad", length = 100, nullable = false)
    private String ciudad;

    @Column(name = "estado", length = 100, nullable = false)
    private String estado;

    @Column(name = "codigo_postal")
    private Long codigoPostal;
}
