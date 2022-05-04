package com.hibernate.services;
import com.hibernate.models.*;
import com.hibernate.dao.UserDAO;

import java.util.List;

public class UserService {
    private UserDAO usersDAO = new UserDAO();

    public UserService(){
    }
    public User findUser(int id){
        return usersDAO.findById(id);
    }
    public void saveUser(User user){
        usersDAO.save(user);
        System.out.println("usersService: Saved!");
    }
    public void deleteUser(User user){
        usersDAO.delete(user);
        System.out.println("usersService: Deleted!");
    }
    public void updateUser(User user){
        usersDAO.update(user);
        System.out.println("usersService: Updated!");
    }
    public List<User> findAllUsers() {
        return usersDAO.findAll();
    }
    public Card findCardById(int id) {
        return usersDAO.findCardById(id);
    }
}
