package com.curso.springM.service.Imp;

import com.curso.spring3.dto.TrianguloDto;
import com.curso.spring3.service.TrianguloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrianguloServiceImpl implements TrianguloService {


    @Override
    public double calcularAreaTriangulo(TrianguloDto requestTrian) {
        double areaTriangulo = (requestTrian.getBaseT() * requestTrian.getAlturaT()) / 2;

        log.info("El area del triangulo es ::. " + areaTriangulo);
        return areaTriangulo;
    }
}
