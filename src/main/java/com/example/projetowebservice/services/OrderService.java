package com.example.projetowebservice.services;

import com.example.projetowebservice.entities.Order;
import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //isso diz para o framework que esta classe de serviço, portanto, poderá ser auto injetada em outra classe.
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }
    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
