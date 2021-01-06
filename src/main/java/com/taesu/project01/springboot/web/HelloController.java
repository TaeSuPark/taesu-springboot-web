package com.taesu.project01.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 구 @ResponseBody
public class HelloController {

    @GetMapping("/hello") // 구 @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
