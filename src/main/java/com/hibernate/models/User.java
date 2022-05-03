package com.hibernate.models;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
<<<<<<< HEAD
    @Column(name="FIO")
=======
    @Column(name = "name")
>>>>>>> b2a3d4121d2ab58bc9ef9f69167e0252d380c901
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;

    public User() {
    }
    public User(String name){
        this.name = name;
        cards = new ArrayList<Card>();
    }
    public void addCard(Card card){
        card.setUser(this);
        cards.add(card);
    }
    public void removeCard(Card card){
        cards.remove(card);
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
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
