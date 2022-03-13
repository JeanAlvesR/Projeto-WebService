package com.example.projetowebservice.services;

import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.repositories.UserRepository;
import com.example.projetowebservice.services.exceptions.DatabaseException;
import com.example.projetowebservice.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        Optional<User> entity = userRepository.findById(id);
        updateData(entity.orElseThrow(() -> new ResourceNotFoundException(id)), obj); //Usei desse jeito, pois estou usando o Optional, pois o getOne foi deprecated.
        return entity.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
