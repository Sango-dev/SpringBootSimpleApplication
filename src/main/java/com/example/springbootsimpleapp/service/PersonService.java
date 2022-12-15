package com.example.springbootsimpleapp.service;

import com.example.springbootsimpleapp.dto.PersonDTO;
import com.example.springbootsimpleapp.model.Person;
import com.example.springbootsimpleapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonService {

    private final PersonRepository productRepository;

    @Autowired
    public PersonService(PersonRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Person> getAll() {
        return productRepository.findAll();
    }

    public PersonDTO findById(String id) {
        Person person = productRepository.findById(id).orElse(null);
        if (person != null) {
            int age = new Date().getYear() - person.getBirthDate().getYear();
            return new PersonDTO(person.getFirstName(), person.getLastName(), age);
        }

        return null;
    }
}
