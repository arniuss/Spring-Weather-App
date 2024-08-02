package cz.vsb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
//    @RequestMapping(value = {"/hello", "/hello/"}, method = RequestMethod.GET)
    @GetMapping({"/hello", "/hello/"})
    public String greeting(){
        return "Hello";
    }
}
