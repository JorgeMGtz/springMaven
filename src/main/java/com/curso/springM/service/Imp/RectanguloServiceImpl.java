package com.curso.springM.service.Imp;

import com.curso.spring3.dto.RectanguloDto;
import com.curso.spring3.service.RectanguloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
//@Sl4j nos ayuda a que log funcione
@Slf4j
public class RectanguloServiceImpl implements RectanguloService{

    @Override
    public double calcularAreaRectangulo(RectanguloDto request) {
        double area = request.getBase() * request.getAltura();
        log.info("El area de reactangulo es: " + area);
        return area;
    }
}
