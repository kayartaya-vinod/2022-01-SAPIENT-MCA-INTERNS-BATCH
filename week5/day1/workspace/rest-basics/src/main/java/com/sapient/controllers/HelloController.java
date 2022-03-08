package com.sapient.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Controller
@RestController // combination of @Controller for the class and @ResponseBody for each handler method
public class HelloController {

    @Value("${hello.message}")
    String message;

    public HelloController() {
        log.debug("HelloController instantiated!");
    }

    @GetMapping("/hello") // @RequestMapping(method=RequestMethod.GET, path="/hello")
    // @ResponseBody // instruction to the view-resolver to send the return value to the client as-is
    // (or in JSON or XML format based on a http header called "Accept"
    public String sayHello(){
        return message;
    }
}
