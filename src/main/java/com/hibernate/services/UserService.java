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
    }
    public void deleteUser(User user){
        usersDAO.delete(user);
    }
    public void updateUser(User user){
        usersDAO.update(user);
    }
    public List<User> findAllUsers() {
        return usersDAO.findAll();
    }
    public Card findAutoById(int id) {
        return usersDAO.findCardById(id);
    }
}
