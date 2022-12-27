package com.example.demoneo4j.service;

import java.util.Optional;

import com.example.demoneo4j.dao.PersonDao;
import com.example.demoneo4j.modal.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    Neo4jTemplate neo4jTemplate;
    @Autowired
    private PersonDao personDao;

    public Optional<Person> getPerson(Long id) {
        return personDao.findById(id);
    }

    public void addPerson(Person person) {
        personDao.save(person);
    }

}
