package com.curso.springM.controller;

import com.curso.spring3.dto.request.DireccionRequest;
import com.curso.spring3.model.Direcciones;
import com.curso.spring3.service.DireccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
@Tag(name = "Direcciones")
public class DireccionesController {

    @Autowired
    private DireccionService direccionService;


    @GetMapping("/direcciones")
    @Operation(summary = "Operacion para obtener toda las direcciones")
    public List<Direcciones> obtenerDirecciones()
    {
        return direccionService.findAlladdress();

    }

    @PostMapping("/direcciones")
    @Operation(summary = "Operacion para Guardar toda las direcciones en la BD")
    public ResponseEntity<Direcciones> GuardarDirecciones(@RequestBody Direcciones direcciones){

        return direccionService.guardarDirecciones(direcciones);
    }

    @PostMapping("/direcciones")
    @Operation(summary = "Operacion para Guardar toda las direcciones en la BD")
    public ResponseEntity<Direcciones> GuardarDirecciones(@RequestBody DireccionRequest direcciones){

        return direccionService.guardarDirecciones2(direcciones);
    }

    @GetMapping("/direcciones/{id}")
    public Direcciones buscarDireccionesPorId(@PathVariable Long id){
        return direccionService.buscarDireccionPorId(id);
    }

    @PutMapping("/direcciones")
    @Operation(summary = "Operración para actualizar un registro de direcciones en la BD")

    public ResponseEntity<Object> updateDircciones(@RequestBody DireccionRequest request){

        return direccionService.updateDirecciones(request);
    }

    @DeleteMapping("/delete-adress")
    @Operation(summary = "Operacion de elminacion de direccion de BD")
    public void eliminarDireccion(@PathVariable Long id){

        direccionService.eliminarDirecciones(id);
    }

}
