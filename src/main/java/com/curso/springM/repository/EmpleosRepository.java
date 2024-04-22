package com.curso.springM.repository;

import com.curso.spring3.model.Empleos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleosRepository extends JpaRepository<Empleos, Long> {



}
