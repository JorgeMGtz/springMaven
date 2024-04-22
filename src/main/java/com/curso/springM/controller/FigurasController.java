package com.curso.springM.controller;

import com.curso.springM.service.RectanguloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class FigurasController {
    @Autowired
    private RectanguloService rectanguloService;

    //Opcion 1
    //@GetMapping("/area-rectangulo/{base}/{altura}")

    //Opcion 2 es mas larga y menos estetica
    @RequestMapping(method = RequestMethod.GET, value = "/area-rectangulo/{base}/{altura}")
    @Operation(Sumary = "Operation para calcular el area de un rectangulo")
    public double calcularRectangulo(@PathVariable @Schema(description = "base de rectangulo", example = "20.46") double base,
                                     @PathVariable @Schema(description = "Altura del rectangulo", example = "10.57") double altura){
        return base * altura;
    }

    @PostMapping("/rectangulo")
    //se pone request ya que es la peticion que se quiere ejecutar
    public double calculateAreaRectangulo(@RequestBody RectanguloDto request){

        double area = request.getBase() * request.getAltura();

        return area;
    }



    @PostMapping("/area-rectangulo2")
    public double calcularAreaRectangulo(@RequestBody RectanguloDto request){
        return  rectanguloService.calcularAreaRectangulo(request);
    }

    @Autowired
    private CirculoService circuloService;

    @GetMapping("/area-circulo/{radio}/")
    public double calcularAreaCirculo(@PathVariable CirculoDto requestCirculo){
        return circuloService.calcularAreaCirculo(requestCirculo);

    }
}
