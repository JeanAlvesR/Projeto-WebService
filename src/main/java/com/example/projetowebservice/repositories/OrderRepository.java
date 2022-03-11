package com.example.projetowebservice.repositories;

import com.example.projetowebservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//Serve para criar um repositório com base no user e no id, que é Long.
public interface OrderRepository extends JpaRepository<Order, Long> { //Só com essa definição está pronto (O spring JPA tem uma implementação padrão), não precisa implementar.


}
