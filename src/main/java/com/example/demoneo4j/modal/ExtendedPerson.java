package com.example.demoneo4j.modal;

import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
@NoArgsConstructor
public class ExtendedPerson {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private int age;

    @Relationship(type = "KnowPerson")
    private List<ExtendedPerson> knowPersons = new ArrayList<>();

    public ExtendedPerson(String name, int age, List<ExtendedPerson> knowPersons) {
        this.name = name;
        this.age = age;
        this.knowPersons.addAll(knowPersons);
    }

    public ExtendedPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void knowThisPerson(ExtendedPerson person) {
        if(person != null) {
            knowPersons.add(person);
        }
    }

    public List<ExtendedPerson> getKnowPersons() {
        return knowPersons;
    }

    public void setKnowPersons(List<ExtendedPerson> knowPersons) {
        this.knowPersons = knowPersons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
