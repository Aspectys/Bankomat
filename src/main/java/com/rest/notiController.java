package com.rest;

import com.hibernate.models.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class notiController {
    private static final String templatestr = "Hello RESTful, %s!";
    private static final String func = "";
    @RequestMapping("/hellorest")
    public Rest withName(@RequestParam(value="uName") String uName, @RequestParam(value="func") String func){
        User user = new User(uName);

        switch (func){
            case"id_get":
                return new Rest(user.getId());
            case"cards_get":
                return new Rest(String.valueOf(user.getCards()));
            default:
                return null;
        }
    }
    @RequestMapping("/hellorest")
    public Rest withId(@RequestParam(value = "uId")int uId, @RequestParam(value="func") String func){
        User user = new User(uId);

        switch (func){
            case"name_get":
                return new Rest(user.getId());
            case"cards_get":
                return new Rest(String.valueOf(user.getCards()));
            default:
                return null;
        }
    }
    /*public Rest withoutFunc(@RequestParam(value="uId")int uId){
        User user = new User(uId);

        return new Rest(uId, uName="s");
    }*/

}


