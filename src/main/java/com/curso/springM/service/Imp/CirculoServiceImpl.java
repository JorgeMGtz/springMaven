package com.curso.springM.service.Imp;

import com.curso.spring3.dto.CirculoDto;
import com.curso.spring3.service.CirculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CirculoServiceImpl implements CirculoService {

    @Override
    public double calcularAreaCirculo (CirculoDto requestCirculo){
        double areaCir = (requestCirculo.getRadio() * requestCirculo.getRadio()) * Math.PI ;

        log.info("El area del circulo es::. " + areaCir);
        return areaCir;
    }


}
