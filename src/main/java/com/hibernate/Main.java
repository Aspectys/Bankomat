package com.hibernate;

import com.hibernate.models.*;
import com.hibernate.services.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[]args)throws SQLException{
        System.out.println("All right!");
        UserService userService = new UserService(); System.out.println("All right!");
        User user = new User("Alimzhan"); System.out.println("All right!");
        userService.saveUser(user); System.out.println("1");
        Card qazcom = new Card("qazkom platinum", 30000);
        user.addCard(qazcom); System.out.println("2");
        Card halyk = new Card("halyk family", 90000);
        user.addCard(halyk); System.out.println("3");
        userService.updateUser(user); System.out.println("4");
        user.setName("Jordan"); System.out.println("5!");
        user.getCards(); System.out.println("6!!");


    }
}
