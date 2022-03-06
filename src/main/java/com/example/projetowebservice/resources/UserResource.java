package com.example.projetowebservice.resources;

import com.example.projetowebservice.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController      //Serve para falar que esta classe é um recurso Web que é implementado pelo controlador rest
@RequestMapping(value = "/users") //Serve para dizer que eles estarão nesse endereço.
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "Maria@gmail.com","99756328", "Senha");
        return ResponseEntity.ok().body(u);
    }
}
