package com.curso.springM.service;

import com.curso.spring3.dto.request.PersonaRequest;
import com.curso.spring3.model.Personas;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {

    List<Personas> findAllPersons();

    ResponseEntity<Personas> guardarPersona(Personas personas);

    ResponseEntity<Personas> guardarPersona2(PersonaRequest personas);

    Personas buscarPersonaPorId(Long id);

    ResponseEntity<Object> updatePersona(PersonaRequest personas);

    //Aqui llamamo a un metodo que no retorna nada ya que es para elminar información
    void eliminarPersona(Long id);

    List<String> personasByGenero(String genero);

    ResponseEntity<Object> getInfoPerson(Integer id);

    ResponseEntity<?> savePersonaNative(PersonaRequest request);

    ResponseEntity<?> updatePersonaNative(PersonaRequest request) throws Exception;

    boolean deletePesonNative (int id) throws Exception;
}
