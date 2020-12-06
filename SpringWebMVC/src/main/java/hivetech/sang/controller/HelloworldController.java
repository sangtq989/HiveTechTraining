package hivetech.sang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloworldController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/hello2")
    public String helloThyme(){
        return "hello_th";
    }
}
