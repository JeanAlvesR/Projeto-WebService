package com.example.projetowebservice.repositories;

import com.example.projetowebservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Serve para criar um repositório com base no user e no id, que é Long.
public interface ProductRepository extends JpaRepository<Product, Long> { //Só com essa definição está pronto (O spring JPA tem uma implementação padrão), não precisa implementar.


}
