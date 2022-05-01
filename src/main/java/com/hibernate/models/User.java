package com.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;

    public User(String name){
        this.name = name;
        cards = new ArrayList<Card>();
    }

    public void setname(String name){
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    @Override
    public String toString(){
        return "models.User{" +
                "id =" + id +"\"" +
                ", name = " + name + "\"" +
                "}";
    }
}
