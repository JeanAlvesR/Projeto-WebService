package com.example.projetowebservice.resources;

import com.example.projetowebservice.entities.Order;
import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.services.OrderService;
import com.example.projetowebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController      //Serve para falar que esta classe é um recurso Web que é implementado pelo controlador rest
@RequestMapping(value = "/orders") //Serve para dizer que eles estarão nesse endereço.
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
