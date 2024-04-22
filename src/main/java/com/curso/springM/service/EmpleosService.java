package com.curso.springM.service;

import com.curso.spring3.dto.request.EmpleosRequest;
import com.curso.spring3.model.Empleos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpleosService {
    List<Empleos> findAllEmployment();

    ResponseEntity<Empleos> guardarEmpleo(Empleos empleos);

    ResponseEntity<Empleos> guardarEmpleo2 (EmpleosRequest empleos);

    Empleos buscarEmpleoPorId (Long id);

    ResponseEntity<Object> updateEmpleos (EmpleosRequest empleos);

    void eliminarEmpleo(Long id);
}
