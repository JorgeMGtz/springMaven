package com.curso.springM.repository;

import com.curso.spring3.model.Direcciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DireccionesRepository extends JpaRepository<Direcciones, Long> {
}
