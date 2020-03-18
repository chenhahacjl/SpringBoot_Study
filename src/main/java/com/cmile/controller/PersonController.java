package com.cmile.controller;

import com.cmile.pojo.Person;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@EnableAutoConfiguration
public class PersonController {

    @RequestMapping("/Person")
    public Object HelloWorld() {

        Person person = new Person();
        person.setId(96);
        person.setName("笑笑");
        person.setDate(new Date());

        return person;
    }
}
