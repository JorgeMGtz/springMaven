package com.curso.springM.service.Imp;

import com.curso.spring3.dto.request.DireccionRequest;
import com.curso.spring3.model.Direcciones;
import com.curso.spring3.repository.DireccionesRepository;
import com.curso.spring3.service.DireccionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionesRepository direccionesRepository;
    @Override
    public List<Direcciones> findAlladdress() {
        return direccionesRepository.findAll();
    }

    @Override
    public ResponseEntity<Direcciones> guardarDirecciones(Direcciones direcciones) {
        return ResponseEntity.ok(direccionesRepository.save(direcciones));
    }

    @Override
    public ResponseEntity<Direcciones> guardarDirecciones2(DireccionRequest request) {

        Direcciones direcciones = new Direcciones();
        direcciones.setCalle(request.getCalle());
        direcciones.setCiudad(request.getCiudad());
        direcciones.setEstado(request.getEstado());
        direcciones.setCodigoPostal(request.getCodigoPostal());

        return ResponseEntity.ok(direccionesRepository.save(direcciones));
    }

    @Override
    @Operation(summary = "Operacion para buscar datos de direcciones por Id")
    public Direcciones buscarDireccionPorId(Long id) {

        Optional<Direcciones> datosDirecciones = direccionesRepository.findById(id);

        return datosDirecciones.get();

    }

    @Override
    public ResponseEntity<Object> updateDirecciones(DireccionRequest request) {

        ResponseEntity<Object> response = null;
        Optional<Direcciones> existeDireccion = direccionesRepository.findById(request.getIdDireccion());

        if(existeDireccion.isPresent()) {

            Direcciones direcciones = new Direcciones();

            direcciones.setDireccionId(request.getIdDireccion());
            direcciones.setCalle(request.getCalle());
            direcciones.setCiudad(request.getCiudad());
            direcciones.setEstado(request.getEstado());
            direcciones.setCodigoPostal(request.getCodigoPostal());

            response = ResponseEntity.ok(direccionesRepository.save(direcciones));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra la direccion")
        }
        return response;
    }

    @Override
    public void eliminarDirecciones(Long id) {
        direccionesRepository.deleteById(id);
    }


}
