package com.taesu.project01.springboot.web;


import com.taesu.project01.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//Posts entity와 통신하지 않는 컨트롤러
@RestController // 구 @ResponseBody
public class HelloController {

    @GetMapping("/hello") // 구 @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        //test code merge
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }
}
