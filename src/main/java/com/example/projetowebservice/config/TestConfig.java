package com.example.projetowebservice.config;


import com.example.projetowebservice.entities.Category;
import com.example.projetowebservice.entities.Order;
import com.example.projetowebservice.entities.Product;
import com.example.projetowebservice.entities.User;
import com.example.projetowebservice.entities.enums.OrderStatus;
import com.example.projetowebservice.repositories.CategoryRepository;
import com.example.projetowebservice.repositories.OrderRepository;
import com.example.projetowebservice.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    //Com a implementação e com o método run implementado, tudo que estiver dentro do escopo durando a inicialização da aplicação será executado
    public void run(String...args) throws Exception{

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888765", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT,u2);
        Order o3 = new Order(null, Instant.parse("2019-08-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT,  u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null,"Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null,"Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null,"PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null,"Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }


}
