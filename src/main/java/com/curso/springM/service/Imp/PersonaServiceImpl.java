package com.curso.springM.service.Imp;

import com.curso.spring3.dto.request.PersonaRequest;
import com.curso.spring3.dto.response.DatosPersonaResponse;
import com.curso.spring3.model.Personas;
import com.curso.spring3.repository.PersonasRepository;
import com.curso.spring3.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//Esta capa se encarga de todos lo metodos las funciones y la lógica de nuestro programa que sera llamda por más
//Cáspas de nuestro programa
@Service
@Slf4j
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonasRepository personasRepository;
    @Override
    public List<Personas> findAllPersons() {

        return personasRepository.findAll();
    }

    @Override
    public ResponseEntity<Personas> guardarPersona(Personas personas) {
        return ResponseEntity.ok(personasRepository.save(personas));
    }

    @Override
    public ResponseEntity<Personas> guardarPersona2(PersonaRequest request) {

        Personas personas = new Personas();
        personas.setNombre(request.getNombre());
        personas.setEdad(request.getEdad());
        personas.setGenero(request.getGenero());
        //personas.setDireccionId(request.getIdDirecciones());
        //personas.setEmpleoId(request.getIdEmpleos());

        return ResponseEntity.ok((personasRepository.save(personas)));
    }

    @Override
    public Personas buscarPersonaPorId(Long id) {
        Optional<Personas> datosPersonas = personasRepository.findById(id);
        return datosPersonas.get();
    }

    @Override
    public ResponseEntity<Object> updatePersona(PersonaRequest request) {

        ResponseEntity<Object> response = null;

        //Modificación para que encaso de actualizar se asegure que existe la persona en la BD
        Optional<Personas> exsitePersona = personasRepository.findById(request.getIdPersona());

       // .isPresent = se usa para saber si el dato tiene información
        if(exsitePersona.isPresent()){

        //En JPA no hay una función de actualizar directo por lo tanto usamos save con una inserción nueva
        //El mismo save actualiza y guarda
        Personas personas = new Personas();

        personas.setPersonalId(request.getIdPersona());
        personas.setNombre(request.getNombre());
        personas.setEdad(request.getEdad());
        personas.setGenero(request.getGenero());
        //personas.setDireccionId(request.getIdDirecciones());
        //personas.setEmpleoId(request.getIdEmpleos());

        response =   ResponseEntity.ok(personasRepository.save(personas));
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la persona");
        }
        //Cuidar que la respuesta sea igual a la petición
        return response;
    }

    @Override
    public void eliminarPersona(Long id) {
        personasRepository.deleteById(id);

    }

    @Override
    public List<String> personasByGenero(String genero) {
        return personasRepository.personasByGenero(genero);
    }

    @Override
    public ResponseEntity<Object> getInfoPerson(Integer id) {

        ResponseEntity<Object> response = null;
        try{

           Optional<DatosPersonaResponse> infoPersona = Optional.ofNullable(personasRepository.getInfoPersonas(id));

           if(infoPersona.isPresent()){
               response = ResponseEntity.ok(infoPersona.get());
           }else {
               response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("No se encontraton los datos de la persona con ID: " + id);
           }

        } catch (Exception e){

            log.error("Error en metodos getInfoPersona: " + e.getMessage());
        }
        return response;
    }

    //Transactinal es necesario para generar la inserción
    @Transactional
    @Override
    public ResponseEntity<?> savePersonaNative(PersonaRequest request) {

        ResponseEntity<?> response = null;
        try {
            log.info("Request guardar: " + request);
            Integer result = personasRepository.saveNativePerson(request);

            if(result > 0){
                response = ResponseEntity.ok().body("El Guardado se realizo exitosamente");
            }else{
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Ocurrio un errror al intentar insertar");
            }
        } catch (Exception e){
            log.error("Error en metodo savePersonaNative : " + e.getMessage());
        }
        return response;
    }

    @Override
    public ResponseEntity<?> updatePersonaNative(PersonaRequest request) throws Exception {
        ResponseEntity<?> response = null;
        try {

            Integer result = personasRepository.updateNativePerson(request);

            if(result > 0){
                response = ResponseEntity.ok().body("El dato se actualizo exitosamente");
            }else{
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Ocurrio un errror al intentar actualizar");
            }
        } catch (Exception e){
            throw new Exception("Error en metodo updatePersonaNative : " + e.getMessage());
        }
        return response;
    }

    //Metodo para eliminar una persona

    @Transactional
    @Override
    public boolean deletePesonNative(int id) throws Exception {
        boolean response = false;

        try {
           personasRepository.deletePersonNative(id);
               response = true;
        }catch (Exception e){
            throw new Exception("Error al Eliminar: " + e.getMessage());
        }
        return response;
    }



}
