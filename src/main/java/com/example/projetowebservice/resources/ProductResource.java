package com.example.projetowebservice.resources;

import com.example.projetowebservice.entities.Product;
import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.services.ProductService;
import com.example.projetowebservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController      //Serve para falar que esta classe é um recurso Web que é implementado pelo controlador rest
@RequestMapping(value = "/products") //Serve para dizer que eles estarão nesse endereço.
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
