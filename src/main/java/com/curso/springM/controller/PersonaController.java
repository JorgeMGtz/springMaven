package com.curso.springM.controller;

import com.curso.spring3.dto.request.PersonaRequest;
import com.curso.spring3.model.Personas;
import com.curso.spring3.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Tag(name = "Personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    @Operation(summary = "Operation para obtener todos los datos de personas")
    public List<Personas> obtenerPersonas(){

        return personaService.findAllPersons();
    }

    @PostMapping("/personas")
    @Operation(summary = "Opertation para guardar personas en BD" )
    public ResponseEntity<Personas> guardarPersonas(@RequestBody PersonaRequest personas){


        return  personaService.guardarPersona2(personas);
    }

    @GetMapping("/persons/{id}")
    @Operation(summary = "Operacion para obtener los datos de una persona por id")
    public Personas buscarPersonaPorId(@PathVariable Long id){
        return personaService.buscarPersonaPorId(id);

    }

    @PutMapping("/persons")
    @Operation(summary = "Operacion para actualizar un registro en BD")
    public ResponseEntity<Object> updatePersona (@RequestBody PersonaRequest request){
        return personaService.updatePersona(request);
    }

    @DeleteMapping("/delete-persons")
    @Operation(summary = "Operacion para eliminar un requisito en BD")
    public void elminarPersona(@PathVariable Long id){

        personaService.eliminarPersona(id);
    }

    @GetMapping("/persona/genero/{genero}")
    @Operation(summary = "Operacion para obtener los datos por genero")
    public List<String> getNobrePersonaByGenero(@PathVariable String genero){

        return personaService.personasByGenero(genero);

    }

    @GetMapping("/persons/info/{id}")
    @Operation(summary = "Operacion para obtener info de persona")
    public ResponseEntity<Object> getInfoPersona(@PathVariable Integer id){

        return personaService.getInfoPerson(id);

    }

    @PutMapping("/persons/save/native")
    @Operation(summary = "Operacion para guardar en BD de manera nativa")
    public ResponseEntity<?> savePersonaNative(@RequestBody PersonaRequest request){
        return personaService.savePersonaNative(request);
    }

    @PutMapping("/persona/native-update")
    @Operation(summary = "Opertion para actualizar en BD de manera nativa")
    public ResponseEntity<?> updatePersonNative(@RequestBody PersonaRequest request) throws Exception {
        return personaService.updatePersonaNative(request);
    }

    @DeleteMapping("/delete-native/person/{id}")
    @Operation(summary = "Operacion para eliminar en BD de manera nativa")
    public boolean deltePersonaNative(@PathVariable int id) throws Exception {
        return personaService.deletePesonNative(id);
    }



}
