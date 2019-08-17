package cn.dhc.logon.controller;

import cn.dhc.logon.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-07-26
 */
@RestController
public class MainController {

    @Value("${hello.name}")
    private String name;
    @GetMapping("/home")
    public String home(){
        return "Hello World "+name;
    }

    @RequestMapping(value = "/person/{personId}",method = RequestMethod.GET)
    public Person findPerson(@PathVariable("personId") Integer personId){
        Person person = new Person();
        person.setId(personId);
        person.setName("Charles");
        person.setAge(28);
        return person;
    }
}
