package com.curso.springM.dto.response.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DireccionRequest {

    private Long idDireccion;
    private String calle;
    private String ciudad;
    private String estado;
    private Long codigoPostal;
}
