package com.taesu.project01.springboot.web;


import com.taesu.project01.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 구 @ResponseBody
public class HelloController {

    @GetMapping("/hello") // 구 @RequestMapping(method = RequestMethod.GET)
    public String hello() {

        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }
}
