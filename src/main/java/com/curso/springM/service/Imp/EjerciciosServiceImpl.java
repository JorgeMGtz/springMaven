package com.curso.springM.service.Imp;

import com.curso.spring3.dto.response.Posts;
import com.curso.spring3.service.EjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service //importante
public class EjerciciosServiceImpl implements EjerciciosService {

    @Override //Para sobre escritura
    public List<String> getNombres() {
        log.info("Entro al metodo getNombres");

        List<String> response = new ArrayList<>();
        List<String> listaNombres = new ArrayList<>();

        listaNombres.add("Jorge");
        listaNombres.add("Edgar");
        listaNombres.add("Octavio");
        listaNombres.add("Silvia");
        //Método 1
     /*   for (String nombre: listaNombres) {
            if(nombre.contains("o")||nombre.contains("0")){
                log.info("Entro al if de lista nombre" + nombre);
                response.add(nombre);
            }
        }*/
/*      //Metodo 2
        int index = 0;
        while (index < listaNombres.size()){
            String nombre = listaNombres.get(index);
            if (nombre.toLowerCase().contains("o")){
                response.add(nombre);
            }
            index++;
        }
*/
        //Metodo 3
/*        int index = 0;

        do {
            String nombre = listaNombres.get(index);
            if (nombre.toLowerCase().contains("i")){
                response.add(nombre);
            }
            index++;
        }while (index < listaNombres.size());
*/
        //Metodo 4 forma resumida
        response = listaNombres.stream()
                .filter(nombre -> nombre.toLowerCase().contains("i"))
                .collect(Collectors.toList());
        return response;

    }
   /*  la no tacion para llamar la url desde "application.yml
    @Value("${spring.url.post}")
    String url;
    */
    @Override
    public Posts getPosts(int id) {

        ResponseEntity<Posts> resultPosts = null;
        try {
            String url = "https://jsonplaceholder.typicode.com/todos/2";
            RestTemplate restTemplate = new RestTemplate();

            //Forma 1
            //ResponseEntity<Posts> resultPosts = restTemplate.exchange(url, HttpMethod.GET, null, Posts.class );

            //Forma 2
            Posts response = restTemplate.getForObject(url, Posts.class);


            resultPosts = ResponseEntity.ok(response);


        }catch (Exception e){
            log.error("Error al consumir el servicio");
        }
        return resultPosts.getBody();
    }
}
