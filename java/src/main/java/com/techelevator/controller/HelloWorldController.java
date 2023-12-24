package com.techelevator.controller;

import com.techelevator.dao.HelloWorldDao;
import com.techelevator.model.HelloWorld;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloWorldController {

    private HelloWorldDao helloWorldDao;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public HelloWorld helloWorld(){
        return helloWorldDao.fetchHelloWorld();
    }
}
