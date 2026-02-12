package com.javatechie.onetoone.controller;




import com.javatechie.onetoone.Repository.PersonRepository;
import com.javatechie.onetoone.Service.PersonService;
import com.javatechie.onetoone.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;


    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }


    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {


        return personService.savePerson(person);
    }


    @GetMapping("/all")
    public List<Person> getAllPersons() {

        return personService.getAllPersons();
    }


    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "Person deleted successfully";
    }
}