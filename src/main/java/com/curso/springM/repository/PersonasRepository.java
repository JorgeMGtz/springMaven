package com.curso.springM.repository;

import com.curso.spring3.dto.request.PersonaRequest;
import com.curso.spring3.dto.response.DatosPersonaResponse;
import com.curso.spring3.model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Long> {
    //Query nativos extraemos una funcion desde la base de datos
    @Query(value = "SELECT p.nombre FROM Personas p WHERE p.genero = :genero")
    List<String> personasByGenero(@PathVariable("genero")String genero);

    //Query nativo
    @Query(value =  "SELECT p.nombre AS nombre, e.titulo AS titulo, e.salario AS salario "
            + " FROM personas p "
            + "JOIN empleos e ON p.empleo_id = e.empleo_id "
            + "WHERE p.persona_id = :idPersona", nativeQuery = true)
    DatosPersonaResponse getInfoPersonas(@Param("idPersona")Integer idPersona);

    //Notacion que no solo es de consulta
    //Clear no ayuda a borrar el chache
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO personas (nombre, edad, genero, direccion_id, empleo_id) "
            + "VALUES "
            + "(:#{#request. nombre}, :#{#request.edad}, :#{#request.genero}, "
            + ":#{#request.idDireccion}, :#{#request.idEmpleo}, 1)", nativeQuery = true)
    Integer saveNativePerson(@Param("request")PersonaRequest request);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE personas SET nombre = ':#{#request.nombre}' WHERE persona_id = :#{#request.idPersona}", nativeQuery = true)
    Integer updateNativePerson(@Param("request")PersonaRequest request);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE personas = ':#request.nombre}' WHERE persona_id = :#{#request.idPersona}", nativeQuery = true)
    Integer deletePersonNative(@Param("id") int id);
}
