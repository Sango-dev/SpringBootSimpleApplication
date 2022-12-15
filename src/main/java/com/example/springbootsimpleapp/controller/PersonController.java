package com.example.springbootsimpleapp.controller;

import com.example.springbootsimpleapp.dto.PersonDTO;
import com.example.springbootsimpleapp.model.Person;
import com.example.springbootsimpleapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Iterable<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable String id) {
        return personService.findById(id);
    }
}
