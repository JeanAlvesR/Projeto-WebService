package com.example.projetowebservice.config;


import com.example.projetowebservice.entities.Order;
import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.repositories.OrderRepository;
import com.example.projetowebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //Fala para o compilador que é uma classe de configuração.
@Profile("test")     //Fala que é especifíca do "test", nome dado para o perfil de teste no doc application.properties.
public class TestConfig  implements CommandLineRunner { //Servirá para fazer o database seeding, ou seja, para popular o banco de dados.

    @Autowired // Com isso, na hora de rodar a aplicação, o framework Spring entenderá e injetará uma instância (injeção de dependência).
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    //Com a implementação e com o método run implementado, tudo que estiver dentro do escopo durando a inicialização da aplicação será executado
    public void run(String...args) throws Exception{

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888765", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1);
        Order o2 = new Order(null, Instant.parse("2019-07-20T19:53:07Z"),u2);
        Order o3 = new Order(null, Instant.parse("2019-08-20T19:53:07Z"),u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));


    }


}
