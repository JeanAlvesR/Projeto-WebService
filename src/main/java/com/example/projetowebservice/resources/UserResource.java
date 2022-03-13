package com.example.projetowebservice.resources;

import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController      //Serve para falar que esta classe é um recurso Web que é implementado pelo controlador rest
@RequestMapping(value = "/users") //Serve para dizer que eles estarão nesse endereço.
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping //A anotation get serve para o mapeamento usar o endereço nomeado em cima e retornar os dados.
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Neste caso ele também retornará os dados, mas no caminho especificado.
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        //serve para mudar a resposta de confirmação do 200 para o 201, pois é um padrão http   
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
