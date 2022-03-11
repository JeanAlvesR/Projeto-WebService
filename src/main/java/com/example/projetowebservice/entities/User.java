package com.example.projetowebservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Os @ aqui são o mapeamento da classe para o JPA entender e transformar
@Entity
@Table(name = "tb_user")
public class User implements Serializable {//Essa implementação serve para que o objeto possa ser transformado em cadeia de bits
    private static final long serialVersionUID = 1L;

    @Id //em cima do atributo Id para falar que será ele o Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Serve para gerar o Id.
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //O JPA não carrega a relação do lado dos muitos por padrão: Lazy Loading
    @JsonIgnore
    //Serve para quebrar o loop que se forma na hora da chamada do banco de dados, pois existe uma referenciação de mão dupla, isto é, User referencia Order e Order referencia User
    @OneToMany (mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {

    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
