package com.example.projetowebservice.repositories;

import com.example.projetowebservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//Serve para criar um repositório com base no entidade e no id, que é Long.
public interface CategoryRepository extends JpaRepository<Category, Long> { //Só com essa definição está pronto (O spring JPA tem uma implementação padrão), não precisa implementar.


}
