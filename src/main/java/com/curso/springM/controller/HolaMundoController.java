package com.curso.springM.controller;

import com.curso.springM.dto.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-spring")
//@Slf4
public class HolaMundoController {

    @Autowired
    private EjerciciosService ejerciciosService;

    @GetMapping("/hola")
    public String holaMundo(){

        return "Hola mundo desde spring";

    }

    @GetMapping(path = "/hola/{nombre}")
    public String holaMundoCustom(@PathVariable("nombre")String nombre){

        log.info("El nombre que se envia atraves de la url es: " + nombre);
        return "Hola mundo" + nombre;
    }
    @PostMapping("/persona")
    public Persona datosPersona(@RequestBody Persona persona){

        return persona;

    }

    @GetMapping("/nombre")
    public List<String> getNombre(){

        return ejerciciosService.getNombres();
    }

}
