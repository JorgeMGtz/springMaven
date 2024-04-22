package com.curso.springM.service.Imp;

import com.curso.spring3.dto.request.EmpleosRequest;
import com.curso.spring3.model.Empleos;
import com.curso.spring3.repository.EmpleosRepository;
import com.curso.spring3.service.EmpleosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleosServiceImpl implements EmpleosService {

    @Autowired
    private EmpleosRepository empleosRepository;

    @Override
    public List<Empleos> findAllEmployment() {

        return empleosRepository.findAll();
    }

    @Override
    public ResponseEntity<Empleos> guardarEmpleo(Empleos empleos) {

        return ResponseEntity.ok(empleosRepository.save(empleos));
    }

    @Override
    public ResponseEntity<Empleos> guardarEmpleo2(EmpleosRequest request) {

        Empleos empleos = new Empleos();
        empleos.setTitulo(request.getTitulo());
        empleos.setEmpresa(request.getEmpresa());
        empleos.setSalario(request.getSalario());

        return ResponseEntity.ok(empleosRepository.save(empleos));
    }

    @Override
    public Empleos buscarEmpleoPorId(Long id) {

        Optional<Empleos> datosEmpleos = empleosRepository.findById(id);

        return datosEmpleos.get();
    }

    @Override
    public ResponseEntity<Object> updateEmpleos(EmpleosRequest request) {

        ResponseEntity<Object> response = null;

        Optional<Empleos> existePersona = empleosRepository.findById(request.getIdEmpleo());

        if (existePersona.isPresent()) {

            Empleos empleos = new Empleos();

            empleos.setEmpleoId(request.getIdEmpleo());
            empleos.setTitulo(request.getTitulo());
            empleos.setEmpresa(request.getEmpresa());
            empleos.setSalario(request.getSalario());

          response = ResponseEntity.ok(empleosRepository.save(empleos));

        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro");
        }
        return response;
    }

    @Override
    public void eliminarEmpleo(Long id) {
        empleosRepository.deleteById(id);
    }
}
