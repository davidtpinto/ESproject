package com.example.jornadaCliente.dao;

import com.example.jornadaCliente.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person); //ADD PERSON WITH SPECIFIC ID

    default int insertPerson(Person person){   //ADD PERSON WITHOUT AN ID
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
