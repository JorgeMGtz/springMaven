package com.curso.springM.service;

import com.curso.spring3.dto.response.Posts;

import java.util.List;

public interface EjerciciosService {

    List<String> getNombres();

    Posts getPosts(int id);
}
