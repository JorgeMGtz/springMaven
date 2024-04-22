package com.curso.springM.service;

import com.curso.spring3.dto.request.DireccionRequest;
import com.curso.spring3.model.Direcciones;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DireccionService {

    List<Direcciones> findAlladdress();

    ResponseEntity<Direcciones> guardarDirecciones(Direcciones direcciones);

    ResponseEntity<Direcciones> guardarDirecciones2(DireccionRequest direccion);

    Direcciones buscarDireccionPorId (Long id);

    ResponseEntity<Object> updateDirecciones (DireccionRequest direccion);

    void eliminarDirecciones(Long id);
}
