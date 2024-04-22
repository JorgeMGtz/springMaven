package com.curso.springM.dto.response.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Posts {

    @JsonProperty(value = "user id")
    private  int userId;
    private int id;
    private String title;
    private boolean completed;


/*    "userId": 1
            "id": 2
            "title": "Quis ut nam facilis et offcia qui"
            "completed": false
  */
}
