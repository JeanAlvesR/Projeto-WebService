package com.example.projetowebservice.services;

import com.example.projetowebservice.entities.Category;
import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.repositories.CategoryRepository;
import com.example.projetowebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //isso diz para o framework que esta classe de serviço, portanto, poderá ser auto injetada em outra classe.
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
