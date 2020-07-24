package com.cache.controller;

import com.cache.bean.Person;
import com.cache.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    private PersonService personService;


//    http://localhost:8080/person/save
    @RequestMapping("/save")
    public String save() {

        Person person = new Person(1001, "陈怀海", "大连街");
        Person person1 = new Person(1002, "李白", "碎叶城");
        Person person2 = new Person(1003, "梭伦", "雅典");
        Person person3 = new Person(1004, "那正红", "大连街");
        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        personService.saveAll(persons);
        return "保存成功";
    }


    //    http://localhost:8080/person/name?name=陈怀海
    @RequestMapping("/name")
    public List<Person> getBypersonName(String name) {
        return personService.findPersonByName(name);
    }

//    http://localhost:8080/person/address?address=大连街
    @RequestMapping("/address")
    public List<Person> getBypersonNameAndAge(String address) {
        return personService.findPersonByAddress(address);
    }


    //    http://localhost:8080/person/id?id=1001
    @RequestMapping("/id")
    public Person getBypersonNameLike(Integer id) {
        return personService.findPersonById(id);
    }
}