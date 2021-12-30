package com.example.jornadaCliente.api;

import com.example.jornadaCliente.model.Person;
import com.example.jornadaCliente.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonByID(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null); // COULD ADD 404 USER NOT FOUND
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

}
