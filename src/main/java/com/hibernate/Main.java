package com.hibernate;

import com.hibernate.models.*;
import com.hibernate.services.UserService;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;

public class Main {
    public static void main(String[]args)throws SQLException{

        UserService userService = new UserService();
        User user = new User("Alimzhan");
        userService.saveUser(user);
        Card qazcom = new Card("qazkom platinum", 30000);
        user.addCard(qazcom);
        Card halyk = new Card("halyk family", 90000);
        user.addCard(halyk);
        user.addCard(halyk);
        userService.updateUser(user);
        user.setName("Jordan");
        user.setName("Jordan");
        user.getCards();
        user.toString();


    }
}
