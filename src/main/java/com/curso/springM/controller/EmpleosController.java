package com.curso.springM.controller;


import com.curso.spring3.dto.request.EmpleosRequest;
import com.curso.spring3.model.Empleos;
import com.curso.spring3.service.EmpleosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleos")
@Tag(name = "Empleos")
public class EmpleosController {

    @Autowired
    private EmpleosService empleoService;

    @GetMapping("/empleos")
    @Operation(summary = "Opereacion para obtener todos los datos de personas")
    public List<Empleos> obtenerEmpleos(){

        return empleoService.findAllEmployment();

    }
    @PostMapping("/empleos")
    @Operation(summary = "Operacion para guardar empleos en BD")
    public ResponseEntity<Empleos> guardarEmpleos(@RequestBody Empleos empleos){

        return empleoService.guardarEmpleo(empleos);
    }

    @PostMapping("/empleos")
    @Operation(summary = "Operacion para guardar empleos en BD 2")
    public ResponseEntity<Empleos> guardarEmpleos(@RequestBody EmpleosRequest empleos){

        return empleoService.guardarEmpleo2(empleos);
    }

    @GetMapping("/empleos/{id}")
    @Operation(summary = "Operacion para buscar datos de Empleo por Id")
    public Empleos buscarEmpleoPorId(@PathVariable Long id) {

        return empleoService.buscarEmpleoPorId(id);
    }

    @PutMapping("/empleos")
    @Operation(summary = "Operacion para actualizar un registro de empleo en la BD")

    public ResponseEntity<Object> updateEmpleo(@RequestBody EmpleosRequest request){

        return empleoService.updateEmpleos(request);
    }

    @DeleteMapping("/delete-employment")
    @Operation(summary = "Operacion eliminar un registro de empleo en BD")
    public void eliminarEmpleo(@PathVariable Long id){

        empleoService.eliminarEmpleo(id);
    }

}