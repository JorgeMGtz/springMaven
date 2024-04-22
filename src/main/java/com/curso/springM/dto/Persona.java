package com.curso.springM.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//Estas anotaciones sustituyen los getter y setters
@Getter
@Setter
//sirve para inprimir todos los metodos
@ToString

public class Persona {


    @NotBlank(message = "El nombre no puede estar vacio o nullo")
    private String nombre;

    @NotBlank(message = "El campo apellido debe traer datos")
    private String apellidoPaterno;
    private String apellidoMaterno;

    //Contiene expresiones regulares en este caso sirve para solo tener dijitos y lo limitamos a 3
    //*\n00fa* es una notación para poder poner una "u" con tilde
    @Pattern(regexp = "[0-9]{1,3}", message = "El campo solo admite n\u00fameros numeros enteros y máximo dos digitos")
    private String edad;
    private String genero;

    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")
    private String email;

}
