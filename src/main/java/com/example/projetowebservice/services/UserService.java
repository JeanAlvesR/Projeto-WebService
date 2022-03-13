package com.example.projetowebservice.services;

import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //isso diz para o framework que esta classe de serviço, portanto, poderá ser auto injetada em outra classe.
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }
}
