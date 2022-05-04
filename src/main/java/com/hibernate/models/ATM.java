package com.hibernate.models;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ATM")
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location")
    private String location;

    @Column(name = "money")
    private int money;

    public void atm(){
    }
    public void atm(String location, int money){
        this.money = money;
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }
}
