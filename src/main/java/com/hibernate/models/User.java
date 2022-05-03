package com.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
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
