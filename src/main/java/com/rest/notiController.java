package com.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class notiController {
    private static final String templatestr = "Hello RESTful, %s!";
    private static final String acc_type = "";
    @RequestMapping("/hellorest")
    public Rest HHelloRest(@RequestParam(value="strname", defaultValue = "World") String strname){
        return new Rest(acc_type,
                String.format(templatestr, strname));
    }
}


