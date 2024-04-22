package com.curso.springM.dto.response.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpleosRequest {
    private Long idEmpleo;
    private String titulo;
    private String empresa;
    private double salario;

}
