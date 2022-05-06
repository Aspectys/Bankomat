package com.rest;

import com.hibernate.models.User;
import com.hibernate.services.UserService;
import com.rest.models.RestUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {
    private static final String templatestr = "Hello RESTful, %s!";
    private static final String func = "";
    @GetMapping("/user")
    public RestUser restUser(@RequestParam(value="uName", defaultValue = "Joe") String uName, @RequestParam(value = "uId", defaultValue = "-1")int uId){
        UserService userService = new UserService();
        return new RestUser();
        /*switch (func){
            case"save":
                User save_user = new User(uName);
                userService.saveUser(save_user);
                return new RestUser(uName, uId);
            case"update":
                User update_user  = new User(uName);
                userService.updateUser(update_user);
                return new RestUser(uName, uId);
            case"delete":
                User delete_user = new User(uName);
                userService.deleteUser(delete_user);
                return new RestUser(uName, uId);
            default:
                String massage = "func is wrong";
                return new RestUser(massage);
        }*/
    }
    /*@RequestMapping("/hellorest/cards")
    public RestUser cards(@RequestParam(value = "card")int uId, @RequestParam(value="uName") String uName, @RequestParam(value="func") String func){
        User user = new User(uId);
        switch (func){
            case"name_get":
                return new RestUser(user.getId());
            case"cards_get":
                return new RestUser(String.valueOf(user.getCards()));
            default:
                return null;
        }
    }*/
    /*public Rest withoutFunc(@RequestParam(value="uId")int uId){
        User user = new User(uId);

        return new Rest(uId, uName="s");
    }*/

}


