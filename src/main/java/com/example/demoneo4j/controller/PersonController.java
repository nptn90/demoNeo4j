package com.example.demoneo4j.controller;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demoneo4j.modal.ExtendedPerson;
import com.example.demoneo4j.modal.Person;
import com.example.demoneo4j.service.ExtendedPersonService;
import com.example.demoneo4j.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private ExtendedPersonService extendedPersonService;

    public void demo1() {
        Person person1 = new Person("Lan", 12);
        personService.addPerson(person1);

        Person person2 = new Person("Nam", 13);
        personService.addPerson(person2);
    }

    @PostConstruct
    public void demo2() {

        ExtendedPerson nam = new ExtendedPerson("Nam", 13);

        ExtendedPerson cuong = new ExtendedPerson("Cuong", 10, List.of(nam, new ExtendedPerson("Long", 20)));

        ExtendedPerson quoc = new ExtendedPerson("Quoc", 10, List.of(
            cuong
        ));

        ExtendedPerson lan = new ExtendedPerson("Lan", 12, List.of(
            quoc
        ));

        extendedPersonService.addPerson(lan);

        lan.knowThisPerson(nam);
        extendedPersonService.addPerson(lan);

        ExtendedPerson hoang = new ExtendedPerson("Hoang", 12, List.of(
            lan, nam
        ));

        extendedPersonService.addPerson(hoang);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExtendedPerson>> getAll() {
        return ResponseEntity.ok(extendedPersonService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ExtendedPerson>> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(extendedPersonService.getPerson(id));
    }

    @GetMapping("/{id}/depth/{depth}")
    public ResponseEntity<Set<ExtendedPerson>> getByIdAndDepth(@PathVariable("id") Long id, @PathVariable("depth") int depth) {
        return ResponseEntity.ok(extendedPersonService.getPerson(id, depth));
    }
}
