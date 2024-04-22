package com.curso.springM.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
*En esta capa damos todo el formato a nusetra tabla que esta
* en SQL igualando el tipo de dato longitud posicion del dato dentro de la tabla
* asi com el nombre del dato
*/

@Entity
//Table sirve para mapear la tabla que mencionasmos
@Table(name = "personas")
@Getter
@Setter
public class Personas {

    //Sirve para llaves primarias sencillas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "persona_id", nullable = false)
    private Long personalId;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name= "edad")
    private  Integer edad;

    @Column(name = "genero")
    private  String genero;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private  Direcciones direccionId;

    @ManyToOne
    @JoinColumn(name = "empleo_id")
    private  Empleos empleoId;

}
