package cn.dhc.logon.controller;

import cn.dhc.logon.emun.DogType;
import cn.dhc.logon.entity.Dog;
import cn.dhc.logon.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-07-26
 */
@RestController
@RequestMapping("/main")
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

    @RequestMapping(value = "/dog/{dogName}",method = RequestMethod.GET)
    public Dog findDog(@PathVariable("dogName") String dogName){
        Dog dog = new Dog();
        dog.setId(new BigDecimal("007"));
        dog.setName(dogName);
        dog.setDescription("this is a magic dog!");
        dog.setDogType(DogType.CHINESE_GARDEN_DOG);
        return dog;
    }

}
