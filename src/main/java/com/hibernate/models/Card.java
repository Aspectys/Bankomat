package com.hibernate;
import javax.persistence.*;
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumns(name = "idUser")
    private User user;
    private int MoneyOnAccount;

    public Card(){
    }

    public void setuser(User user) {
        this.user = user;
    }

    public void setMoneyOnAccount(int moneyOnAccount) {
        MoneyOnAccount = moneyOnAccount;
    }

    public int getMoneyOnAccount() {
        return MoneyOnAccount;
    }

    public User getuser() {
        return user;
    }
}
