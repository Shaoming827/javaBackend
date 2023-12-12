package com.shaoming.springPractice.controller;

import com.shaoming.springPractice.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User user() {
        User user = new User();
        user.setName("Shaoming");
        user.setEmail("xsm90827@gmail.com");
        user.setId("123456789");
        return user;
    }

    @GetMapping("/user/{id}/{username}")
    public User userByPathVariable(@PathVariable String id, @PathVariable("username") String name) {
        User user = new User();
        user.setName(name);
        user.setEmail("xsm90827@gmail.com");
        user.setId(id);
        return user;
    }

    @GetMapping("/userrequest")
    public User userByRequestParam(
            @RequestParam String id,
            @RequestParam("username") String name,
            @RequestParam(required = false, defaultValue = " ") String email){
        User user = new User();
        user.setName(name);
        user.setEmail("xsm90827@gmail.com");
        user.setId(id);
        return user;
    }
}
