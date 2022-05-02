package com.hibernate.models;
import javax.persistence.*;
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private User user;
    private int money;

    public Card(){
    }
    public Card(String cardName, int money){
        this.cardName = cardName;
        this.money = money;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setmoney(int money) {
        money = money;
    }

    public int getmoney() {
        return money;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id =" + id +
                "\"" + "cardName =" + cardName +
                "\", user =" + user +
                "\", money =\"" + money +
                '}';
    }
}
